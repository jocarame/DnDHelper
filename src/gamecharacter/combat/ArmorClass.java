package gamecharacter.combat;

import gamecharacter.GameCharacter;
import gamecharacter.Size;
import gamecharacter.abilities.AbilityScores;

public class ArmorClass {

	private GameCharacter character;

	private int naturalArmor;
	private int deflectionModifier;
	private int miscModifier;

	public ArmorClass(GameCharacter character, int naturalArmor, int deflectionModifier, int miscModifier) {
		this.character = character;
		this.naturalArmor = naturalArmor;
		this.deflectionModifier = deflectionModifier;
		this.miscModifier = miscModifier;
	}

	public int getArmorClassTotal() {
		return 10 + getArmorBonus() + getShieldBonus() + getDexModifier() + getSizeModifier() + getNaturalArmor() + getDeflectionModifier() + getMiscModifier();
	}

	public int getArmorBonus() {
		return character.getArmor().getACBonus();
	}

	public int getShieldBonus() {
		return character.getShield().getACBonus();
	}

	public int getDexModifier() {
		int dex = character.getAbilityScores().getDex();
		return AbilityScores.calculateMod(dex);
	}

	public int getSizeModifier() {
		return Size.getSizeModifier(character.getSize());
	}

	public int getNaturalArmor() {
		return naturalArmor;
	}

	public int getDeflectionModifier() {
		return deflectionModifier;
	}

	public int getMiscModifier() {
		return miscModifier;
	}

	public int getTouchArmorClass() {
		return getArmorClassTotal() - getArmorBonus() - getShieldBonus() - getNaturalArmor();
	}
	public int getFlatFootedArmorClass() {
		return getArmorClassTotal() - getDexModifier();
	}

	public void setNaturalArmor(int naturalArmor) {
		this.naturalArmor = naturalArmor;
	}

	public void setDeflectionModifier(int deflectionModifier) {
		this.deflectionModifier = deflectionModifier;
	}

	public void setMiscModifier(int miscModifier) {
		this.miscModifier = miscModifier;
	}

}
