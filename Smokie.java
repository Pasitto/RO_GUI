public class Smokie {
    protected int hp, exp, zeny, attack; 
    public Smokie() {
        hp = 100;
        exp = 40;
        zeny = 20;
        attack = -25;
    }
    public int getHp(){
        return hp;
    } 
    public int getExp(){
        return exp;
    } 
    public int getZeny(){
        return zeny;
    } 
    public int getAttack(){
        return attack;
    }
    public void HpUpdate(int num){
        hp -= num;
    }
    public void setHp(){
        hp = 100;
    } 
}