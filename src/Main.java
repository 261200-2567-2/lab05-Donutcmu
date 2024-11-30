import java.util.Objects;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static void fightSystem(Player player,Enemy enemy) {
        player.getStatus();
        enemy.getEnemyStatus();
        if(player.playerSpeed>enemy.enemySpeed){
            System.out.println("Player choose action first");
            System.out.println("Your turn");
            System.out.println("select Action : |1|Attack |2|RUN");
        }
        else{
            System.out.println("Player choose action second");
            enemy.enemyAttack(player);
        }

        while(player.playerIsAlive()){
            if(!player.playerIsAlive()){
                System.out.println("You  is defeated");
                break;
            }
            if(!enemy.enemyIsAlive()){
                System.out.println(enemy.enemyName+" is defeated");
                System.out.println(" You win the fight");
                player.playerLevelUP(player.sword,player.shield);
                player.getStatus();
                break;
            }
            Scanner playerInput = new Scanner(System.in);
            System.out.println("Your turn");
            System.out.println("select Action : |1|Attack |2|RUN");
            int playerAction = playerInput.nextInt();
            if(playerAction==1){
                System.out.println("Choose skill: ");
                System.out.println("[1] normal attack ");
                System.out.println("[2] shikai ");
                System.out.println("[3] bankai ");

                boolean isPicked = false;
                while(!isPicked){
                    Scanner playerPickSkill = new Scanner(System.in);
                    int playerSkill = playerPickSkill.nextInt();

                    if(playerSkill==1){
                        if(Objects.equals(player.job.jobName, "Warrior")){
                            int skilldamage = player.job.warrior.normalATk();
                            enemy.enemyGotHit(skilldamage);
                        }else{
                            int skilldamage = player.job.mage.normalATk();
                            enemy.enemyGotHit(skilldamage);
                        }
                        isPicked = true;
                    }
                    else if(playerSkill==2){
                        if(Objects.equals(player.job.jobName, "Warrior")){
                            int skilldamage = player.job.warrior.shikai();
                            enemy.enemyGotHit(skilldamage);
                        }else{
                            int skilldamage = player.job.mage.shikai();
                            enemy.enemyGotHit(skilldamage);
                        }
                        isPicked = true;
                    }
                    else if(playerSkill==3){
                        if(Objects.equals(player.job.jobName, "Warrior")){
                            int skilldamage = player.job.warrior.bankai();
                            enemy.enemyGotHit(skilldamage);
                        }else{
                            int skilldamage = player.job.mage.bankai();
                            enemy.enemyGotHit(skilldamage);
                        }
                        isPicked = true;
                    }
                    else{
                        System.out.println("Invalid action");
                    }
                }

                player.playerAttack(enemy);

                enemy.enemyAttack(player);

            }
            else if(playerAction==2){
                if(player.playerSpeed> enemy.enemySpeed){
                    System.out.println("You got away from "+enemy.enemyName);
                    break;
                }else{
                    System.out.println("Enemy speed is more than you can not escape");
                    enemy.enemyAttack(player);
                }}
            else if(playerAction==3){
                player.Healed();
            }

            else{
                System.out.println("Invalid action");
            }

        }

    }

    public static void starterSystem(Player player){
        player.getStatus();
        System.out.println("Pick your job");
        boolean selectIsDone = false;
        System.out.println("[1] Warrior [2] Mage ");
        while(!selectIsDone){
            Scanner playerInput = new Scanner(System.in);
            int playerPickingJob = playerInput.nextInt();
            if(playerPickingJob==1){
                Warrior playerWarrior = new Warrior(1);
                player.job = new Job(playerWarrior,null);
                selectIsDone = true;
            }
            else if(playerPickingJob==2){
                Mage playerMage = new Mage(1);
                player.job = new Job(null,playerMage);
                selectIsDone = true;
            }
            else{
                System.out.println("Invalid action");
            }
        }
        System.out.println("You picked :"+player.job.jobName);
        System.out.println("Pick a accessories");
        boolean selectAccessoriesIsDone = false;
        System.out.println("[1] RingOfMagic [2] GloveOfWarrior ");
        while(!selectAccessoriesIsDone){
            Scanner playerInput = new Scanner(System.in);
            int playerPickingAccessories = playerInput.nextInt();
            if(playerPickingAccessories==1){
                ringofMagic playerring = new ringofMagic(1);
                playerring.wearRingOfMagic(player);
                player.accesoriesname = "RingOfMagic";
                selectAccessoriesIsDone = true;
                player.getStatus();
            } else if (playerPickingAccessories==2) {
                player.accesoriesname = "GloveOfWarrior";
                gloveofWarrior playerGlove = new gloveofWarrior(1);
                playerGlove.wearGloveOfWarrior(player);
                player.getStatus();
                selectAccessoriesIsDone = true;
            }
            else {
                System.out.println("Invalid action");
            }
        }

    }

    public static void main(String[] args) {
        Scanner playerInput = new Scanner(System.in);
        System.out.println("Hello and welcome! to my RPG game");
        System.out.print("Enter your character name: ");
        String playerName = playerInput.nextLine();
        Sword woodenSword = new Sword(1);
        Shield woodenShield = new Shield(1);
        Player p = new Player(playerName,1,woodenSword,woodenShield);
        Enemy zombie = new Enemy("zombie",10);
        starterSystem(p);
        fightSystem(p,zombie);
    }
}