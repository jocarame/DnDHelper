package gamecharacter.combat;

import gamecharacter.GameCharacter;
import gamecharacter.abilities.AbilityScores;

public class Initiative {

	private GameCharacter character;
	private int miscModifier;

	public Initiative(GameCharacter character, int miscModifier) {
		this.character = character;
		this.miscModifier = miscModifier;
	}

	public int getTotal() {
		int dexMod = character.getAbilityScores().getDex();
		    dexMod = AbilityScores.calculateMod(dexMod);
		return dexMod + getMiscModifier();
	}
	public int getMiscModifier() {
		return miscModifier;
	}
	public void setMiscModifier(int miscModifier) {
		this.miscModifier = miscModifier;
	}

}