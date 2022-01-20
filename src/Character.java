public abstract class Character {

    String name;
    byte health;
    int gold;
    byte agility;
    byte strength;
    byte experience;
    byte damage;
    byte meds;

    public Character() {
        this.name = null;
        this.health = 100;
        this.gold = 50;
        this.agility = 0;
        this.experience = 0;
        this.strength = 0;
        this.meds = 0;
    }

    public void attack() {
        byte fightLuck = (byte) (Math.random() * 100);
        if (experience > fightLuck) {
            damage = (byte) (strength * 2);
            System.out.println(name + " нанес КРИТИЧЕСКИЙ удар с уроном " + damage);
        } else if ((agility * 3) > fightLuck) {
            damage = strength;
            System.out.println(name + " нанес удар с уроном " + damage);
        } else {
            damage = 0;
            System.out.println(name + " промахнулся");
        }
    }


}
