import java.util.Scanner;

public class Game {
    static Player player;

    public static void main(String[] args) {

        playerCreator();
        actionOption();

    }

    static void playerCreator() {
        System.out.println("Введите имя своего персонажа");
        player = new Player();
    }

    static void actionOption() {
        System.out.println("Куда вы хотите пойти?"); // варианты: 1-3 , 4 - лечиться
        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextByte();

        switch (action) {
            case 1:
                System.out.println("Вы отправились в тёмный лес");
                Battle battle = new Battle();
                battle.start();
                break;
            case 2:
                System.out.println("Вы пришли к торговцу");
                Trading trading = new Trading();
                trading.purchase();
                break;
            case 3:
                System.out.println("Вы ушли на покой");
                break;
            /*case 4:
                System.out.println("Осталось зелья ___, уровень здоровья ___");
                player.heal();
                break;*/
            default:
                System.out.println("Введённое значение не соответсвует доступным вариантам");
        }

    }

}
