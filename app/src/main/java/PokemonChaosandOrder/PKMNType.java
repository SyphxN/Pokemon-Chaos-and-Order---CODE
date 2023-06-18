/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PokemonChaosandOrder;

/**
 *
 * @author SyphiN
 */
import java.util.Arrays;

public class PKMNType {
    private PKMNType[] typeWeakness;
    private PKMNType[] typeAdvantage;
    private String type;

    PKMNType(){

    }

    PKMNType(String typeName){
        type = typeName;
    }
    PKMNType(String t, PKMNType[] weakness, PKMNType[] advantage){
        type = t;
        typeWeakness = weakness;
        typeAdvantage = advantage;
    }

    public void setWeakness(PKMNType weakness[]){
        typeWeakness = weakness;
    }

    public void setTypeAdvantage(PKMNType advantage[]){
        typeAdvantage = advantage;
    }

    public String getType(){
        return type;
    }

    public String getWeaknesses(){
        String weaknesses = "";
        try {
            for (int i = 0; i < 18; i++) {
                weaknesses = weaknesses + " " + typeWeakness[i].getType();
            }
        }catch(Exception e){
            return weaknesses;
        }
        return weaknesses;
    }

    public String getTypeAdvantages(){
        String typeAdvantages = "";
        try {
            for (int i = 0; i < 18; i++) {
                typeAdvantages = typeAdvantages + " " + typeAdvantage[i].getType();
            }
        }catch(Exception e){
            return typeAdvantages;
        }
        return typeAdvantages;
    }

    public double getEffectiveness(PKMNType[] atkType, PKMNType[] defType){
        double effectiveness = 1;
        for(int j = 0; j<atkType.length; j++) {
            for (int i = 0; i < defType.length; i++) {
                if (Arrays.asList(atkType[j].typeAdvantage).contains(defType[i])){
                    effectiveness*=2;
                }
            }
        }
        for(int j = 0; j<atkType.length; j++) {
            for (int i = 0; i < defType.length; i++) {
                if (Arrays.asList(atkType[j].typeWeakness).contains(defType[i])){
                    effectiveness/=2;
                }
            }
        }
        return effectiveness;
    }

}
