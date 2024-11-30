public class Shield
{
    int shieldLevel;
    int shieldDefense = 10;
    int ShieldRunSpeedDecrease;
    public Shield(int ShieldLevel) {
        this.shieldLevel = ShieldLevel;
        shieldDefense += 10+(2*ShieldLevel);
        ShieldRunSpeedDecrease += 10+(5/ShieldLevel);
    }
}
