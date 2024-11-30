
public class Warrior  implements skill {
    static String name = "Warrior";
    int level;
    public Warrior(int level) {
        this.level = level;
    }

    @Override
    public int normalATk()  {
        return level*5;
    }

    @Override
    public int shikai() {
        System.out.println("Player use basic skill : shikai ");
        return level*7;
    }

    @Override
    public  int bankai() {
        System.out.print("Player use Ultimate skill");
        String sentence = "... BANKAI! GETSUKA TENSHOU ...";
        System.out.println(sentence);
        return level*10;
    }
}
