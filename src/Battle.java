public class Battle extends Thread {
    byte foeChoice = (byte) Math.round(Math.random());
    Character foe = getFoe();


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

    @Override
    public void run() {
        System.out.println(Game.player.damage);
        Game.actionOption();
    }
}

