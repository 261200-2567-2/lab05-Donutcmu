public class Sword {
    int swordLevel;
    int swordDamage = 25;
    int SwordRunSpeedDecrease;
    public Sword(int swordLevel) {
        this.swordLevel = swordLevel;
        swordDamage += 0.6*swordLevel;
        SwordRunSpeedDecrease += (5/swordLevel);
    }
}
