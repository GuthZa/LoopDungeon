package Models;

public class LivingEntity {
    protected String Name;
    protected int CurrentHitPoints;
    protected int MaximumHitPoints;

    protected int Level;

    protected GameItem EquippedWeapon;
    protected GameItem CurrentConsumable;

    public boolean isDead = CurrentHitPoints <= 0;
    public LivingEntity(String name, int maximumHP, GameItem weapon) {
        this.Name = name;
        this.EquippedWeapon = weapon;
        this.MaximumHitPoints = maximumHP;
        this.CurrentHitPoints = maximumHP;
        this.Level = 1;
    }
    //Getters and Setters -----------------------------------------------------------------
    public String getName() {
        return this.Name;
    }
    private void setName(String name) {
        this.Name = name;
    }

    public int getMaximumHitPoints() {
        return this.MaximumHitPoints;
    }
    protected void setMaximumHitPoints(int maximumHitPoints) {
        this.MaximumHitPoints = maximumHitPoints;
    }
    public int getCurrentHitPoints() {
        return CurrentHitPoints;
    }
    private void setCurrentHitPoints(int hitPoints) {
        this.CurrentHitPoints = hitPoints;
    }
    public GameItem getEquippedWeapon() {
        return EquippedWeapon;
    }
    public void setEquippedWeapon(GameItem weapon) {
        this.EquippedWeapon = weapon;
    }

    public GameItem getCurrentConsumable() {
        return this.CurrentConsumable;
    }

    public void setCurrentConsumable(GameItem consumable) {
        this.CurrentConsumable = consumable;
    }

    public int getLevel() {
        return this.Level;
    }
    protected void setLevel(int experiencePoints) {
        int originalLevel = Level;
        Level = (experiencePoints/100) + 1;
        if(Level!=originalLevel) {
            setMaximumHitPoints(Level * 10);

            //Level up!
        }
    }

    //End Gets and Sets -----------------------------------------------------------------

    //Methods -----------------------------------------------------------------

    public void takeDamage(int hitPointsOfDamage) {
        CurrentHitPoints -= hitPointsOfDamage;
        if(isDead) {
            CurrentHitPoints = 0;
            //On killedEvent
        }
    }

    //End Methods -----------------------------------------------------------------

}
