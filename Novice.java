public class Novice {
    protected int hp, sp, exp, zeny, level, attack, kill; 
    protected String name;
    public Novice(String name){
        level = 1;
        exp = 0;
        hp = 200;
        sp = 50;
        zeny = 0;
        attack = 40; 
        this.name = name;
        kill = 0;
    }
    public String getName(){
        return name;
    }
    public int getHp(){
        return hp;
    } 
    public int getSp(){
        return sp;
    } 
    public int getLvl(){
        return level;
    } 
    public int getZeny(){
        return zeny;
    } 
    public int getKill(){
        return kill;
    }
    public int getAttack(){
        return attack;
    }
    public int getExp(){
        return exp;
    }
    public void hpUpdate(int num){
        hp += num;
    }
    public void spUpdate(int num){
        sp += num;
    } 
    public void zenyUpdate(int num){
        zeny += num;
    } 
    public void expUpdate(int num){
        exp += num;
    }
    public void lvlUP() {
        level += 1;
    } 
    public void killUp(){
        kill += 1;
    }
}