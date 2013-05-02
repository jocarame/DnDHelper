package gamecharacter.type;

import java.util.Random;

/**
 * This class sets the character class and the best ability score for each class
 * 
 * @author Garrett Mozena
 *
 */
public class CharType {
	
	/**
	 * Identifier for the Barbarian class
	 */
	public static final int BARBARIAN = 0;
	
	/**
	 * Identifier for the Bard class
	 */
	public static final int BARD = 1;
	
	/**
	 * Identifier for the Cleric class
	 */
	public static final int CLERIC = 2;
	
	/**
	 * Identifier for the Druid class
	 */
	public static final int DRUID = 3;
	
	/**
	 * Identifier for the Fighter class
	 */
	public static final int FIGHTER = 4;
	
	/**
	 * Identifier for the Monk class
	 */
	public static final int MONK = 5;
	
	/**
	 * Identifier for the Paladin class
	 */
	public static final int PALADIN = 6;
	
	/**
	 * Identifier for the Ranger class
	 */
	public static final int RANGER = 7;
	
	/**
	 * Identifier for the Rogue class
	 */
	public static final int ROGUE = 8;
	
	/**
	 * Identifier for the Sorcerer class
	 */
	public static final int SORCERER = 9;
	
	/**
	 * Identifier for the Wizard class
	 */
	public static final int WIZARD = 10;
	
	private String[] classes = new String[] {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Wizard"};
	private int[] bestAbility = new int[] {0, 5, 4, 4, 0, 0, 0, 4, 1, 5, 3};
	private int[] worstAbility = new int[] {5, 0, 3, 1, 1, 3, 5, 0, 4, 3, 5};
	private static final int[] hitdie = new int[] {12, 6, 8, 8, 10, 8, 10, 8, 6, 4, 4};
	private static final int[] skillMod = new int[] {4, 6, 2, 4, 2, 4, 2, 6, 8, 2, 2};
	private static final int[] bab = new int[] {2, 1, 1, 1, 2, 1, 2, 2, 1, 0, 0};
	private String chClass;
	
	/**
	 * Character class constructor that sets a random class
	 */
	public CharType(){
		Random rng = new Random();
		chClass = classes[rng.nextInt(11)];		
	}
	
	/**
	 * Character class constructor that sets the class as the given class.
	 * @param type the class to set the character to.
	 */
	public CharType(String type){
		chClass = type;
	}
	
	/**
	 * Gets the class of the character.
	 * @return chClass the class of the character.
	 */
	public String getClassType(){
		return chClass;
	}
	
	/**
	 * Sets the class to the given argument.
	 * @param c the class to be set.
	 * @return the new class.
	 */
	public String setClassType(String c){
		int i = 0;
		while (!c.equals(classes[i])){
			i++;
			if(i == 11) return null;
		}
		return chClass = c;
	}
	
	/**
	 * gets the hit die of the class.
	 * @return the hit die of the class.
	 */
	public int getHitDie(){
		int i = 0;
		while (!chClass.equals(classes[i])){
			i++;
		}
		return hitdie[i];
	}
	
	/**
	 * get the best ability for the class.
	 * @return the best ability.
	 */
	public int getBestAbility(){
		int i = 0;
		while (!chClass.equals(classes[i])){
			i++;
		}
		return bestAbility[i];
	}
	
	/**
	 * gets the worst ability or least important for the character.
	 * @return the worst or least important ability.
	 */
	public int getWorstAbility(){
		int i = 0;
		while (!chClass.equals(classes[i])){
			i++;
		}
		return worstAbility[i];
	}
	
	/**
	 * gets the skill point modifier for the specified class.
	 * @param c the class to find the skill modifier for.
	 * @return the skill modifier.
	 */
	public int getSkillMod(){
		int i = 0;
		while (!chClass.equals(classes[i])){
			i++;
		}
		return skillMod[i];
	}
	
	/**
	 * gets the base attack bonus rate for the character.
	 * @return the base attack bonus rate.
	 */
	public int getBab(){
		int i = 0;
		while (!chClass.equals(classes[i])){
			i++;
		}
		return bab[i];
	}

}
