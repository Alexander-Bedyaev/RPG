public class Battle extends Thread {
    byte foeChoice = (byte) Math.round(Math.random());
    Character foe = getFoe();

    private Character getFoe() {
        if (foeChoice == 0) {
            foe = new Skeleton();
            System.out.println("Вы сталкнулись со скелетом");
        } else {
            foe = new Goblin();
            System.out.println("Вы сталкнулись с гоблином");
        }
        return foe;
    }

    @Override
    public void run() {

        while (true) {
            Game.player.attack();
            foe.health = (byte) (foe.health - Game.player.damage);
            System.out.println("Уровень здоровья " + foe.name + "а: " + foe.health);
            if (foe.health <= 0) {
                break;
            }
            try {
                this.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            foe.attack();
            Game.player.health = (byte) (Game.player.health - foe.damage);
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


