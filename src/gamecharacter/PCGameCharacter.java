package gamecharacter;

import gamecharacter.abilities.AbilityScores;
import gamecharacter.abilities.Feat;
import gamecharacter.abilities.Skill;
import gamecharacter.abilities.SpecialAbilities;
import gamecharacter.abilities.Spell;
import gamecharacter.combat.ArmorClass;
import gamecharacter.combat.DamageReduction;
import gamecharacter.combat.Grapple;
import gamecharacter.combat.Initiative;
import gamecharacter.combat.SavingThrow;
import gamecharacter.equipment.Armor;
import gamecharacter.equipment.Equipment;
import gamecharacter.equipment.ProtectiveItem;
import gamecharacter.equipment.Shield;
import gamecharacter.equipment.Weapon;
import gamecharacter.type.CharType;
import gamecharacter.type.Race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PCGameCharacter implements GameCharacter {

	private AbilityScores abilityScores;
	private ArrayList<Integer> abilities = new ArrayList<Integer>();
	private int level;
	private ArrayList<Integer> hitDiceRolls = new ArrayList<Integer>();

	/**
	 * The number of sides of the dice used for rolling hit points.
	 */
	private int hitDie;
	private int speed;
	private String chClass;
	private String race;
	private ArmorClass armorClass;
	private Size size;
	private List<DamageReduction> damageReductions;
	private Initiative initiative;
	private SavingThrow fortitudeSavingThrow;
	private SavingThrow reflexSavingThrow;
	private SavingThrow willSavingThrow;
	private int baseAttackBonus;
	private int babRate;
	private int spellResistance;
	private Grapple grapple;
	private List<Skill> skills;
	private List<Feat> feats;
	private List<Spell> spells;
	private List<String> languages;
	private int skillPoints;
	private Race r;
	private CharType ct;

	public PCGameCharacter() {
		level = 1;
		r = new Race();
		race = r.getRace();
		ct = new CharType();
		chClass = ct.getClassType();
		hitDie = ct.getHitDie();
		abilityScores = new AbilityScores();
		skillPoints = getSkillPoints(ct.getSkillMod());
		babRate = ct.getBab();
		addLanguage("common");
		
	}

	@Override
	public AbilityScores getAbilityScores() {
		return abilityScores;
	}
	

	public ArrayList<Integer> getAbilities(){
		abilities.add(abilityScores.getStr());
		abilities.add(abilityScores.getCon());
		abilities.add(abilityScores.getDex());
		abilities.add(abilityScores.getWis());
		abilities.add(abilityScores.getInt());
		abilities.add(abilityScores.getCha());
		return abilities;
	}

	@Override
	public int getHitPoints() {
		int hitPoints = hitDie;
		int conMod = abilityScores.getCon();
		    conMod = AbilityScores.calculateMod(conMod);
		hitPoints += conMod;
		if (level > 1){
			rollHitDice();
			for (int r : hitDiceRolls) hitPoints += r;
		}
		return hitPoints;
	}
	

	/**
	 * Rolls one hit dice per level and stores the results in hitDiceRolls. 
	 */
	private void rollHitDice() {
		Random random = new Random();
		while(hitDiceRolls.size() < getLevel()) {
			int roll = random.nextInt(hitDie) + 1;
			hitDiceRolls.add(roll);
		}
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public String getClassType(){
		return chClass;
	}

	public void setClass(String c){
		chClass = ct.setClassType(c);
	}

	@Override
	public String getRace(){
		return race;
	}

	public void setRace(String newr){
		r.setRace(newr);
		race = newr;
	}

	@Override
	public Size getSize() {
		return size;
	}

	@Override
	public ArmorClass getArmorClass() {
		return armorClass;
	}

	@Override
	public List<DamageReduction> getDamageReductions() {
		return damageReductions;
	}

	@Override
	public Initiative getInitiative() {
		return initiative;
	}

	@Override
	public SavingThrow getFortitudeSavingThrow() {
		return fortitudeSavingThrow;
	}

	@Override
	public SavingThrow getReflexSavingThrow() {
		return reflexSavingThrow;
	}

	@Override
	public SavingThrow getWillSavingThrow() {
		return willSavingThrow;
	}

	@Override
	public int getBaseAttackBonus() {
		boolean same = false;
		baseAttackBonus = 0;
		if (babRate == 2){
			for(int i = 1; i <= level; i++) baseAttackBonus += 1;
		}
		else if (babRate == 1){
			baseAttackBonus -= 1;
			for(int i = 1; i <= level; i++){
				baseAttackBonus += 1;
				if (baseAttackBonus % 3 == 0){
					same = true;
				}
				if (baseAttackBonus % 3 != 0 && same == true){
					baseAttackBonus -= 1;
					same = false;
				}
			}
		}
		else{
			baseAttackBonus = level / 2;
		}
		return baseAttackBonus;
	}

	@Override
	public int getSpellResistance() {
		return spellResistance;
	}

	@Override
	public Grapple getGrapple() {
		return grapple;
	}

	@Override
	public List<Skill> getSkills() {
		return skills;
	}
	
	public int getSkillPoints(){
		return skillPoints;
	}
	
	/**
	 * uses the intelligence modifier of the character to calculate the number of skill points 
	 * available for the character to use on skills.
	 * 
	 * @param mod the intelligence modifier from the character's ability scores.
	 * @return the total number of available skill points.
	 */
	public int getSkillPoints(int mod){
		int intMod = abilityScores.getInt();
			intMod = AbilityScores.calculateMod(intMod);
		int skillPoints = (mod + intMod) * 4;
		if (chClass.equals("Human")) skillPoints += 4;
		for(int j=1; j < level; j++){
			skillPoints += (mod + intMod);
			if (chClass.equals("Human")) skillPoints += 1;
		}
		if (skillPoints < 4) skillPoints = 4;
		return skillPoints;
	}
	
	/**
	 * gets the maximum number of class skill ranks
	 * @return the number or ranks.
	 */
	public int getMaxRank(){
		return level + 3;
	}

	@Override
	public int getExperiencePoints() {
		/* formula extrapolated from table on PHB pg 22 */
		int x = getLevel();
		return (500 * x * x) - (500 * x);
	}

	@Override
	public int getLevel() {
		return level;
	}

	public void setLevel(int lvl){
		level = lvl;
	}

	@Override
	public List<Weapon> getWeapons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Armor getArmor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shield getShield() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProtectiveItem> getProtectiveItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Equipment> getOtherPossessions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Load getLoads() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Money getMoney() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Feat> getFeats() {
		return feats;
	}
	
	/**
	 * adds the feat to the character's list of feats.
	 * @param feat the feat to be added.
	 */
	public void addFeat(Feat feat){
		feats.add(feat);
	}
	
	/**
	 * removes the specified feat from the list of feats for the character.
	 * @param feat the feat to be removed.
	 * @return the new list of remaining feats.
	 */
	public List<Feat> removeFeat(Feat feat){
		feats.remove(feat);
		return feats;
	}

	@Override
	public List<SpecialAbilities> specialAbilities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getLanguages() {
		return languages;
	}
	
	/**
	 * adds a language to the list of languages know by the character.
	 * @param l the language to add.
	 */
	public void addLanguage(String l){
		languages.add(l);
	}
	
	/**
	 * searches the list of languages and finds the index of the language to remove.
	 * @param l the language to remove.
	 */
	public void removeLanguage(String l){
		int i = 0;
		for (String o : languages){
			if (!o.equals(l)) i++;
		}
		languages.remove(i);
	}

	@Override
	public List<Spell> getSpells() {
		return spells;
	}

}