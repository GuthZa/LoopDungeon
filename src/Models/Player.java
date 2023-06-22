package Models;

public class Player extends LivingEntity {

    private int ExperiencePoints;
    public Player(String name, int maxHP, GameItem weapon, int experiencePoints) {
        super(name, maxHP, weapon);
        this.ExperiencePoints = experiencePoints;
    }
    public int getExperiencePoints() {
        return this.ExperiencePoints;
    }

    public void AddExperience(int experiencePoints) {
        this.ExperiencePoints = experiencePoints;
        setLevelAndMaximumHitPoints();
    }
    private void setLevelAndMaximumHitPoints() {
        setLevel(ExperiencePoints);
    }
}
