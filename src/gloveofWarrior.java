import java.util.Objects;

public class gloveofWarrior implements accessories{

    int level;
    public static String name = "Glove of Warrior";
    boolean isWear;

    public gloveofWarrior(int level) {
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
        return level+2;
    }

    @Override
    public int upStamina() {
        return level*3;
    }
    public void wearGloveOfWarrior(Player player) {

        if(isWear==false) {
            if(Objects.equals(player.job.jobName, "Warrior")){
                player.playerBuff(upDMG()*2,upSpeed()*2,upDef(),upStamina()*2);
                isWear = true;
            }
            else if(Objects.equals(player.job.jobName, "Mage")){
                player.playerBuff(upDMG()*3/2,upSpeed()/2,upDef(),upStamina());
                isWear = true;

            }else{
                return;
            }
        }else{
            System.out.println("You have already wear this accessories.");
        }


    }
}
