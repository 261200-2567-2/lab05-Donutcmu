public class Job {
    String jobName;
    Warrior warrior;
    Mage mage;
    public Job( Warrior warrior, Mage mage) {
        this.warrior = warrior;
        this.mage = mage;
        if(warrior==null&&mage==null){
            this.jobName = "empty";
        }
        else{
            if(warrior==null){
                this.jobName = Mage.name;
            }
            else{
                this.jobName = Warrior.name;
            }
        }

    }
}
