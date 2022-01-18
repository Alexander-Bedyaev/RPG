public abstract class Character implements Attackable {

    String name;
    int health;
    double gold;
    int agility;
    int strength;
    int experience;

    public Character() {
        this.name = null;
        this.health = 100;
        this.gold = 50;
        this.agility = 0;
        this.experience = 0;
        this.strength = 0;


    }


    void attack() {

    }


}
