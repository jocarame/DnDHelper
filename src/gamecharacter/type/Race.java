package gamecharacter.type;

import java.util.Random;

public class Race {
	
	//identifiers
	
	/**
	 * Identifier for the Dwarf race
	 */
	public static final int DWARF = 0;
	
	/**
	 * Identifier for the Elf race
	 */
	public static final int ELF = 1;
	
	/**
	 * Identifier for the Gnome race
	 */
	public static final int GNOME = 2;
	
	/**
	 * Identifier for the Half-elf race
	 */
	public static final int HALFELF = 3;
	
	/**
	 * Identifier for the Half-orc race
	 */
	public static final int HALFORC = 4;
	
	/**
	 * Identifier for the Halfling race
	 */
	public static final int HALFLING = 5;
	
	/**
	 * Identifier for the Human race
	 */
	public static final int HUMAN = 6;
	
	private String[] races = new String[] {"Dwarf","Elf","Gnome","Half-elf","Half-orc","Halfling","Human"};
	private String race;
	
	/**
	 * Character race constructor that sets a random race
	 */
	public Race(){
		Random rng = new Random();
		race = races[rng.nextInt(7)];		
	}
	
	/**
	 * Character race constructor that sets the character race as the given race
	 * @param r the race to set the character to
	 */
	public Race(String r){
		race = r;
	}
	
	/**
	 * gets the race of the character
	 * @return the race of the character
	 */
	public String getRace(){
		return race;
	}
	
	public String setRace(String r){
		return race = r;
	}
}
