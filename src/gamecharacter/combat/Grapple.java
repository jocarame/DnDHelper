package gamecharacter.combat;

import gamecharacter.GameCharacter;
import gamecharacter.Size;
import gamecharacter.abilities.AbilityScores;

public class Grapple {



	private GameCharacter character;
	private int miscModifier;


	public Grapple(GameCharacter character, int miscModifier)
	{
		this.character = character;
		this.miscModifier = miscModifier;
	}

	public int getBaseAttackBonus() {
		return character.getBaseAttackBonus();
	}
	public int getStrModifier() {
		int strMod = character.getAbilityScores().getStr();
		return AbilityScores.calculateMod(strMod);
	}
	public int getSizeModifier() {
		return Size.getSizeModifier(character.getSize());
	}
	public int getMiscModifier() {
		return miscModifier;
	}

}