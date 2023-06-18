/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PokemonChaosandOrder;

/**
 *
 * @author SyphiN
 */
import java.net.MalformedURLException;
import java.net.URL;

public class Pokemon {
    // instance variables
    private String name;
    private int level;
    private int[] ivs;
    private int baseHP;
    private int baseAttack;
    private int baseDefense;
    private int baseSpecialAttack;
    private int baseSpecialDefense;
    private int baseSpeed;
    private String[] abilities;
    private PKMNType[] types;
    private Move[] moves;
    private int hp;
    private int maxHP;
    private BattleGUI.Status currentStatus;
    private URL imageURL;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;


    public Pokemon(String name, int level, int[] ivs, int baseHP, int baseAttack, int baseDefense, int baseSpecialAttack, int baseSpecialDefense, int baseSpeed, PKMNType[] types, Move[] moves, String url) throws MalformedURLException {
        this.name = name;
        this.level = level;
        this.ivs = ivs;
        this.baseHP = baseHP;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
        this.baseSpecialAttack = baseSpecialAttack;
        this.baseSpecialDefense = baseSpecialDefense;
        this.baseSpeed = baseSpeed;
        this.types = types;
        this.moves = moves;
        this.maxHP = (int)(0.01 * (2 * baseHP + 15 + (int)(0.25 * 85)) * level) + level + 10;
        this.hp = maxHP;
        this.imageURL = new URL(url);
        this.attack = calculateStat(baseAttack, 1); // Non-base stat for attack
        this.defense = calculateStat(baseDefense, 1); // Non-base stat for defense
        this.specialAttack = calculateStat(baseSpecialAttack, 3); // Non-base stat for special attack
        this.specialDefense = calculateStat(baseSpecialDefense, 3); // Non-base stat for special defense
        this.speed = calculateStat(baseSpeed, 2); // Non-base stat for speed
    }

    //cloning constructor
    public Pokemon(Pokemon clone){
        this.name = clone.getName();
        this.level = clone.getLevel();
        this.ivs = clone.getIvs();
        this.baseHP = clone.getBaseHP();
        this.baseAttack = clone.getBaseAttack();
        this.baseDefense = clone.getBaseDefense();
        this.baseSpecialAttack = clone.getBaseSpecialAttack();
        this.baseSpecialDefense = clone.getBaseSpecialDefense();
        this.baseSpeed = clone.getBaseSpeed();
        this.types = clone.getTypes();
        this.moves = clone.getMoves();
        this.hp = clone.getBaseHP();
        this.imageURL = clone.getImageURL();
        this.attack = clone.getAttack();
        this.defense = clone.getDefense();
        this.specialAttack = clone.getSpecialAttack();
        this.specialDefense = clone.getSpecialDefense();
        this.speed = clone.getSpeed();
    }
    
    
    // methods
    
    private int calculateStat(int baseStat, int statIndex) {
        double scalingFactor;

        switch (statIndex) {
            case 1: // Attack and Defense
                scalingFactor = 2.0;
                break;
            case 2: // Speed
                scalingFactor = 1.0;
                break;
            case 3: // Special Attack and Special Defense
                scalingFactor = 1.5;
                break;
            default:
                return 0;
        }

        double scaledStat = (int)((ivs[statIndex] + 2 * baseStat + Math.sqrt(ivs[statIndex]) / 4.0) * level / 100.0);
        return (int)(scalingFactor * scaledStat + 5);
    }
    
    public void attack(String move) {
        System.out.println(this.name + " uses " + move + "!");
    }

    public void takeDamage(int damage) {
        System.out.println(this.name + " takes " + damage + " damage!");
    }

    public void levelUp() {
        this.level++;
        System.out.println(this.name + " leveled up to level " + this.level + "!");
    }

    // getters and setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int[] getIvs() {
        return this.ivs;
    }

    public void setIvs(int[] ivs) {
        this.ivs = ivs;
    }

    public int getBaseHP() {
        return this.baseHP;
    }

    public void setBaseHP(int baseHP) {
        this.baseHP = baseHP;
    }

    public int getBaseAttack() {
        return this.baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public int getBaseDefense() {
        return this.baseDefense;
    }

    public void setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }

    public int getBaseSpecialAttack() {
        return this.baseSpecialAttack;
    }

    public void setBaseSpecialAttack(int baseSpecialAttack) {
        this.baseSpecialAttack = baseSpecialAttack;
    }

    public int getBaseSpecialDefense() {
        return this.baseSpecialDefense;
    }

    public void setBaseSpecialDefense(int baseSpecialDefense) {
        this.baseSpecialDefense = baseSpecialDefense;
    }

    public int getBaseSpeed() {
        return this.baseSpeed;
    }

    public void setBaseSpeed(int baseSpeed) {
        this.baseSpeed = baseSpeed;
    }

    public String[] getAbilities() {
        return this.abilities;
    }

    public void setAbilities(String[] abilities) {
        this.abilities = abilities;
    }

    public PKMNType[] getTypes() {
        return this.types;
    }

    public void setTypes(PKMNType[] types) {
        this.types = types;
    }

    public Move[] getMoves() {
        return this.moves;
    }

    public void setMoves(Move[] moves) {
        this.moves = moves;
    }

    public int getHp(){return hp;}

    public void setHp(int newHp){
        hp = newHp;
        if(hp>maxHP){
            hp = maxHP;
        }
        if(hp<0){
            hp=0;
        }
    }
    
    public int getMaxHP(){return maxHP;}

    public void setMaxHP(int newHp){maxHP = newHp;}
    
    public URL getImageURL(){return imageURL;};
    
        public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

