

public class Mage implements skill {
    static String name = "Mage";
    int level ;
    public Mage(int level) {
        this.level = level;
    }
    @Override
    public int normalATk() {

        return level*2;
    }

    @Override
    public int shikai() {
        System.out.println("Player use basic skill : shikai");
        return level*10;
    }

    @Override
    public  int bankai() {
        System.out.print("Player use Ultimate skill");
        System.out.println("... BANKAI! FUGAAA");
        return level*15;
    }

}
