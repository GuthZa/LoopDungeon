package main.models;

public class Monster extends LivingEntity{
    int ID;
    public Monster(int id, String name, int maximumHP, GameItem weapon) {
        super(name, maximumHP, weapon);
        this.ID = id;
    }
    public int getID() { return this.ID; }

    public Monster getNewMonster() {
        return new Monster(ID, Name, MaximumHitPoints, EquippedWeapon);
    }
}
