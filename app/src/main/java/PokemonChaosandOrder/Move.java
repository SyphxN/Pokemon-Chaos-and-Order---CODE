package PokemonChaosandOrder;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Move {
    private String moveName;
    private int Accuracy;
    private int Damage;
    private int pp;
    private int ppMax;
    private PKMNType moveType;
    private String dmgType;
    private double recoilAmount;
    private double selfHealing;
    private boolean movePriority;
    private BattleGUI.Status status;
    private double statusAcc;
    Move(String name, int acc, int dmg, int ppM, PKMNType type, String damageType, double recoil, double selfHeal, boolean priority){
        moveName = name;
        Accuracy = acc;
        Damage = dmg;
        pp = ppM;
        ppMax = ppM;
        moveType = type;
        dmgType = damageType;
        recoilAmount = recoil;
        selfHealing = selfHeal;
        movePriority = priority;
    }
    
    Move(String name, int acc, int dmg, int ppM, PKMNType type, String damageType, double recoil, double selfHeal, boolean priority, BattleGUI.Status moveStatus, double statAcc){
        moveName = name;
        Accuracy = acc;
        Damage = dmg;
        pp = ppM;
        ppMax = ppM;
        moveType = type;
        dmgType = damageType;
        recoilAmount = recoil;
        selfHealing = selfHeal;
        movePriority = priority;
        status = moveStatus;
        statusAcc = statAcc;
    }
    
    Move(Move clone){
        moveName = clone.getName();
        Accuracy = clone.getAccuracy();
        Damage = clone.getDamage();
        pp = clone.getMaxPP();
        ppMax = clone.getMaxPP();
        moveType = clone.getType();
        dmgType = clone.getDamageType();
        recoilAmount = clone.getSelfAfflictHP();
        selfHealing = clone.getSelfHealing();
        movePriority = clone.getPriority();
        status = clone.getStatusEffect();
        statusAcc = clone.getStatusAccuracy();
    }
    public String attack(Pokemon thisPokemon, Pokemon enemyPokemon){
        PKMNType check = new  PKMNType();
        Random rand = new Random();
        int hitChance = rand.nextInt(100);
        double critChance = rand.nextDouble() * 100;
        double baseValueAtk;
        String result;
        String critMessage;
        String recoilMessage;
        if (dmgType.equals("Special")){
            baseValueAtk = (double)thisPokemon.getBaseSpecialAttack()/enemyPokemon.getBaseSpecialDefense();
        }else{
            baseValueAtk = (double)thisPokemon.getBaseAttack()/enemyPokemon.getBaseDefense();
        }
        //System.out.println(spAtk);
        float STAB = 1;
        double effectiveness = check.getEffectiveness(thisPokemon.getTypes(), enemyPokemon.getTypes());
        int critMultiplier = 1;
        double dmgDealt = 0;
        double randomMultiplier = ThreadLocalRandom.current().nextDouble(0.85, 1);
        String effectivenessMessage;
        if (hitChance<=Accuracy){

            if(Arrays.asList(thisPokemon.getTypes()).contains(moveType)){
                STAB = 1.5f;
            }

            if(critChance<=6.25){
                critMultiplier = 2;
                critMessage = "\nIt was a Critical Hit";
            }else{
                critMessage = "";
            }
            
            dmgDealt = ((double)Damage*STAB*effectiveness*critMultiplier*randomMultiplier*((double)(2*thisPokemon.getLevel()+10)/250)*baseValueAtk);
            
            if(recoilAmount<0){
                recoilMessage = "\n"+thisPokemon.getName()+" drained " +(int)(thisPokemon.getHp()-(recoilAmount*dmgDealt))+" hp from "+enemyPokemon.getName()+".";
            }else if(recoilAmount>0){
                recoilMessage = "\nIt hurt itself and suffered " +(int)(recoilAmount*dmgDealt)+" hp from recoil.";
            }else{
                recoilMessage = "";
            }
            
            
            if(effectiveness>1){
                effectivenessMessage = "\nIt was Super Effective";
            }else if(effectiveness<1){
                effectivenessMessage = "\nIt was not very effective";
            }else{
                effectivenessMessage = "";
            }
            
            result = thisPokemon.getName()+" used "+moveName+" and dealt "+ (int)dmgDealt+" damage. "+critMessage+effectivenessMessage+recoilMessage;            
            enemyPokemon.setHp((int)Math.round(enemyPokemon.getHp()-dmgDealt));
            thisPokemon.setHp((int) (thisPokemon.getHp()-(recoilAmount*dmgDealt)));
            thisPokemon.setHp((int)selfHealing*thisPokemon.getMaxHP()+thisPokemon.getHp());
            
            if(selfHealing != 0){
                result = thisPokemon.getName()+" healed "+selfHealing*thisPokemon.getMaxHP()+" hp.";
            }
        }else{
            result = thisPokemon.getName()+" used missed the attack!";
        }
        
        
        return result;
    }
    
    public String getName(){
        return moveName;
    }
    
    
    public int getAccuracy(){
        return Accuracy;
    }
    
    public int getDamage(){
        return Damage;
    }
    
    public int getPP(){
        return pp;
    }
    
    public int getMaxPP(){
        return ppMax;
    }
    
    public PKMNType getType(){
        return moveType;
    }
    
    public String getDamageType(){
        return dmgType;
    }
    
    public double getSelfAfflictHP(){
        return recoilAmount;
    }
    
    public double getSelfHealing(){
        return selfHealing;
    }
    
    public boolean getPriority(){
        return movePriority;
    }
    
    public BattleGUI.Status getStatusEffect(){
        return status;
    }
    
    public double getStatusAccuracy(){
        return statusAcc;
    }
}
