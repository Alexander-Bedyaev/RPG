import java.util.Scanner;

public class Player extends Character {

    Scanner scanner = new Scanner(System.in);


    public Player() {
        this.name = scanner.nextLine();
        this.agility = 20;
        this.strength = 20;
    }

    public void heal() {
        System.out.println("Ваше здоровье - " + health + ", у вас " + meds + " порций лекарства.");
        System.out.println("Сколько лекарства вы хотите принять?");
        int medsToTake = scanner.nextByte();
        byte healthToRecover = (byte) (100 - health);
        if (health != 100 && medsToTake <= meds && 0 < medsToTake) {
            if (medsToTake * 20 <= healthToRecover) {
                health = (byte) (health + medsToTake * 20);
                meds = meds - medsToTake;
                System.out.println("Вы поправили здоровье до " + health);
            } else {
                int maxMedsToTake = healthToRecover / 20 + 1;
                health = 100;
                meds = meds - maxMedsToTake;
                System.out.println("Вы поправили здоровье до " + health);
            }
        } else {
            System.out.println("Столько лекарства принимать нельзя");
        }
        System.out.println("У вас " + meds + " порций лекарста");
        Game.actionOption();
    }



}
