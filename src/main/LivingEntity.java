package main.models;

public class LivingEntity {
    protected String name_;
    protected int currentHitPoints_;
    protected int maximumHitPoints_;

    protected int level_;

    protected GameItem equippedWeapon_;
    protected GameItem currentConsumable_;

    public boolean isDead = currentHitPoints_ <= 0;
    public LivingEntity(String name, int maximumHP, GameItem weapon) {
        this.name_ = name;
        this.equippedWeapon_ = weapon;
        this.maximumHitPoints_ = maximumHP;
        this.currentHitPoints_ = maximumHP;
        this.level_ = 1;
    }
    //Getters and Setters -----------------------------------------------------------------
    public String getName_() {
        return this.name_;
    }
    private void setName_(String name_) {
        this.name_ = name_;
    }

    public int getMaximumHitPoints_() {
        return this.maximumHitPoints_;
    }
    protected void setMaximumHitPoints_(int maximumHitPoints_) {
        this.maximumHitPoints_ = maximumHitPoints_;
    }
    public int getCurrentHitPoints_() {
        return currentHitPoints_;
    }
    private void setCurrentHitPoints_(int hitPoints) {
        this.currentHitPoints_ = hitPoints;
    }
    public GameItem getEquippedWeapon_() {
        return equippedWeapon_;
    }
    public void setEquippedWeapon_(GameItem weapon) {
        this.equippedWeapon_ = weapon;
    }

    public GameItem getCurrentConsumable_() {
        return this.currentConsumable_;
    }

    public void setCurrentConsumable_(GameItem consumable) {
        this.currentConsumable_ = consumable;
    }

    public int getLevel_() {
        return this.level_;
    }
    protected void setLevel_(int experiencePoints) {
        int originalLevel = level_;
        level_ = (experiencePoints/100) + 1;
        if(level_ !=originalLevel) {
            setMaximumHitPoints_(level_ * 10);

            //Level up!
        }
    }

    //End Gets and Sets -----------------------------------------------------------------

    //Methods -----------------------------------------------------------------

    public void takeDamage(int hitPointsOfDamage) {
        currentHitPoints_ -= hitPointsOfDamage;
        if(isDead) {
            currentHitPoints_ = 0;
            //On killedEvent
        }
    }

    //End Methods -----------------------------------------------------------------

}
