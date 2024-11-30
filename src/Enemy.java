public class Enemy {
    String enemyName;
    private int  level;
    private int maxHP;
    private int currentHP;
    private int stamina;
    private int maxStamina;
    int enemySpeed;
    private int damage;
    private int defense;
    public Enemy(String enemyName, int level) {
        this.enemyName = enemyName;
        this.level = level;
        this.maxHP = 50+(2*level);
        this.currentHP = maxHP;
        this.maxStamina = 50+(2*level);
        this.stamina = maxStamina;
        this.damage = 5+(2*level);
        this.defense = 5+(2*level);
        this.enemySpeed = maxStamina/2;
    }

    void getEnemyStatus(){
        System.out.println("-----"+ enemyName+"'s status is here-----");
        System.out.println("Level: "+this.level);
        System.out.println("HP: "+this.currentHP + " / " + this.maxHP);
        System.out.println("Stamina: "+this.stamina + " / " + this.maxStamina);
        System.out.println("Speed: "+this.enemySpeed);
        System.out.println("Damage: "+this.damage);
        System.out.println("Defense: "+this.defense);
        System.out.println("--------------------------------");
    }
    void enemyAttack(Player player){
        System.out.println("Enemy choose attack");
        player.playerGotAttacked(damage);
        stamina -= 5;

    }
    void enemyGotHit(int hitDamage){
        currentHP -= hitDamage-(defense/15);
        if(currentHP <= 0){
            currentHP = 0;
        }
        System.out.println(enemyName+" HP :"+currentHP + " / " + maxHP);
    }
    boolean enemyIsAlive(){
        if(currentHP <= 0) {
            currentHP = 0;
            return false;
        }else{
            return true;
        }
    }

}

