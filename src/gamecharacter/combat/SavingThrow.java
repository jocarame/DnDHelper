package gamecharacter.combat;

import gamecharacter.GameCharacter;
import gamecharacter.abilities.AbilityScores;

public class SavingThrow {

	private GameCharacter character;
	private int ability;
	private int baseSave;
	private int magicModifier;
	private int miscModifier;

	public SavingThrow(GameCharacter character, int ability, int baseSave, int magicModifier, int miscModifier) {
		this.character = character;
		this.ability = ability;
		this.baseSave = baseSave;
		this.magicModifier = magicModifier;
		this.miscModifier = miscModifier;
	}

	public int getTotal() {
		return getBaseSave() + getAbilityModifier() + getMagicModifier() + getMiscModifier();
	}
	public int getBaseSave() {
		return baseSave;
	}
	public int getAbilityModifier() {
		int abilityScore = character.getAbilityScores().getAbilityScore(ability);
		return AbilityScores.calculateMod(abilityScore);
	}
	public int getMagicModifier() {
		return magicModifier;
	}
	public int getMiscModifier() {
		return miscModifier;
	}

}
