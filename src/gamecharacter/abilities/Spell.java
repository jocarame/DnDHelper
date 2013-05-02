package gamecharacter.abilities;

import java.util.List;


public interface Spell {
	
	/**
	 * gets a list of available spells for the character.
	 * @param chclass the class of the character.
	 * @param level the level of the character.
	 * @return the list of spells available for the character.
	 */
	public List<Spell> getSpells(String chclass, int level);
	
	
}