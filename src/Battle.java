public class Battle extends Thread {
    byte foeChoice = (byte) Math.round(Math.random());
    Character foe = getFoe();
    byte damage;

    public Character getFoe() {
        if (foeChoice == 0) {
            foe = new Skeleton();
            System.out.println("Вы сталкнулись со скелетом");
        } else {
            foe = new Goblin();
            System.out.println("Вы сталкнулись с гоблином");
        }
        return foe;
    }

    private void getDamage(Character hitter) {
        byte fightLuck = (byte) (Math.random() * 100);
        if (hitter.experience > fightLuck) {
            damage = (byte) (hitter.strength * 2);
            System.out.println(hitter.name + " нанес КРИТИЧЕСКИЙ удар с уроном " + damage);
        } else if ((hitter.agility * 3) > fightLuck) {
            damage = hitter.strength;
            System.out.println(hitter.name + " нанес удар с уроном " + damage);
        } else {
            damage = 0;
            System.out.println(hitter.name + " промахнулся");
        }

    }

    @Override
    public void run() {

        while (true) {
            getDamage(Game.player);
            foe.health = (byte) (foe.health - damage);
            System.out.println("Уровень здоровья " + foe.name + "а: " + foe.health);
            if (foe.health <= 0) {
                break;
            }
            try {
                this.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            getDamage(foe);
            Game.player.health = (byte) (Game.player.health - damage);
            System.out.println("Уровень здоровья " + Game.player.name + "а: " + Game.player.health);
            if (Game.player.health <= 0) {
                break;
            }
            try {
                this.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        if (foe.health <= 0) {
            Game.player.experience = (byte) (Game.player.experience + 5);
            Game.player.gold = Game.player.gold + foe.gold;
            System.out.println(foe.name + " повержен!");
            System.out.println("У вас " + Game.player.health + " очков здоровя, " + Game.player.experience + " очков опыта и " + Game.player.gold + " золота");
            Game.actionOption();
        } else {
            System.out.println(Game.player.name + " погиб");
        }
    }
}


