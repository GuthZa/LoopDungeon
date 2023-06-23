package entity;

import java.awt.image.BufferedImage;

public class LivingEntity {
    protected String name_;
    protected int currentHitPoints_;
    protected int maximumHitPoints_;

    public int x, y;
    public int speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    protected int level_;

    public boolean isDead = currentHitPoints_ <= 0;
    public LivingEntity() {
    }
    //Getters and Setters -----------------------------------------------------------------
    public String getName() {
        return this.name_;
    }
    private void setName(String name_) {
        this.name_ = name_;
    }

    public int getMaximumHitPoints() {
        return this.maximumHitPoints_;
    }
    protected void setMaximumHitPoints(int maximumHitPoints_) {
        this.maximumHitPoints_ = maximumHitPoints_;
    }
    public int getCurrentHitPoints() {
        return currentHitPoints_;
    }
    private void setCurrentHitPoints(int hitPoints) {
        this.currentHitPoints_ = hitPoints;
    }

    public int getLevel() {
        return this.level_;
    }
    protected void setLevel(int experiencePoints) {
        int originalLevel = level_;
        level_ = (experiencePoints/100) + 1;
        if(level_ !=originalLevel) {
            setMaximumHitPoints(level_ * 10);

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

    public void Heal(int hitPointsToHeal) {
        currentHitPoints_ += hitPointsToHeal;
        if(currentHitPoints_ > maximumHitPoints_) {
            currentHitPoints_ = maximumHitPoints_;
        }
    }

    public void completelyHeal() {
        currentHitPoints_ = maximumHitPoints_;
    }
    //End Methods -----------------------------------------------------------------

}
