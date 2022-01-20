import java.util.Scanner;

public class Player extends Character {

    Scanner nameScanner = new Scanner(System.in);


    public Player() {
        this.name = nameScanner.nextLine();
        this.agility = 20;
        this.strength = 20;
    }

    public void perchase() {


    }

    public void heal() {

    }



}
