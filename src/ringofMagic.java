import java.util.Objects;

public class ringofMagic implements accessories{
    public static String name = "ring of Magic";
    int level;
    boolean isWear;
    public ringofMagic(int level) {
        this.level = level;
        this.isWear = false;
    }


    @Override
    public int upDMG() {
        return 2*level;
    }

    @Override
    public int upDef() {
        return level/2;
    }

    @Override
    public int upSpeed() {
        return 0;
    }

    @Override
    public int upStamina() {
        return level*3;
    }



    public void wearRingOfMagic(Player player) {

        if(isWear==false) {
            if(Objects.equals(player.job.jobName, "Warrior")){
                player.playerBuff(upDMG(),upSpeed(),upDef()/2,upStamina()/2);
                isWear = true;
            }
            else if(Objects.equals(player.job.jobName, "Mage")){
                player.playerBuff(upDMG()*3,upSpeed()/2,upDef()/3,upStamina());
                isWear = true;

            }else{
                return;
            }
        }else{
            System.out.println("You have already wear this accessories.");
        }


    }
}
