public class Player {
    String playerName;
    Job job;
    private int  level;
    private int maxHP;
    private int currentHP;
    private int stamina;
    private int maxStamina;
    int playerSpeed;
    private int damage;
    private int defense;
    String accesoriesname;
    Sword sword;
    Shield shield;
    public Player(String playerName,int level,Sword sword,Shield shield) {
        this.playerName = playerName;
        this.level = level;
        this.maxHP = 100+(10*level);
        this.maxStamina = 100+(5*level);
        this.stamina = maxStamina;
        this.currentHP = maxHP;
        this.playerSpeed = 50+(2*level);
        if(sword == null) {
            this.damage = 10+(2*level);
        }else {
            this.sword = sword;
            this.damage = (sword.swordDamage)+(10+(2*level));
            this.playerSpeed -= sword.SwordRunSpeedDecrease;
        }
        if(shield == null) {
            this.defense = 10+(2*level);
        }else{
            this.shield = shield;
            this.defense=(shield.shieldDefense)+(10+(2*level));
            this.playerSpeed -= shield.shieldDefense;
        }
    }

    public Player(String playerName,int level) {
        this.playerName = playerName;
        this.level = level;
        this.maxHP = 100+(10*level);
        this.maxStamina = 100+(5*level);
        this.stamina = maxStamina;
        this.currentHP = maxHP;
        this.playerSpeed = 50+(5*level);
        this.damage = 10+(2*level);
        this.defense = 10+(2*level);
    }

    void getStatus(){
        System.out.println("-----"+ playerName+"'s status is here-----");
        System.out.println("Level: "+this.level);
        System.out.println("HP: "+this.currentHP + " / " + this.maxHP);
        System.out.println("Stamina: "+this.stamina + " / " + this.maxStamina);
        System.out.println("Speed: "+this.playerSpeed);
        System.out.println("Damage: "+this.damage);
        System.out.println("Defense: "+this.defense);
        if(sword != null) {
            System.out.println("Sword Level : "+sword.swordLevel);
        }
        if(shield != null) {
            System.out.println("Shield Level : "+shield.shieldLevel);
        }
        System.out.println("--------------------------------");

    }
    void Healed(){
        currentHP = maxHP;
        stamina = maxStamina;
    }

    void playerAttack(Enemy enemy){
        System.out.println("Player choosed attack");
        enemy.enemyGotHit(damage);
        stamina -= 5;
    }
    void playerGotAttacked(int enemyDamage){
        currentHP -= enemyDamage-(defense/10);
        if(currentHP <= 0) {
            currentHP = 0;
        }
        System.out.println("Your Hp :"+currentHP + " / " + maxHP);
    }
    boolean playerIsAlive(){
        if(currentHP <= 0) {
            currentHP = 0;
            System.out.println("Player is dead");
            System.out.println("You is defeated.");
            return false;
        }else{
            return true;
        }
    }

    void playerLevelUP(Sword sword,Shield shield){
        level+=1;
        sword.swordLevel += 1;
        shield.shieldLevel += 1;
    }

    void playerIncreaseDmg(int dmg){
        damage += dmg;
    }

    void playerBuff(int damage,int playerSpeed,int defense,int stamina){
        this.damage += damage;
        this.playerSpeed += playerSpeed;
        this.defense += defense;
        this.stamina += stamina;
    }
}
