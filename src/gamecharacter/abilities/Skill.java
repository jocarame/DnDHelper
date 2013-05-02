package gamecharacter.abilities;

import gamecharacter.GameCharacter;

public class Skill {

	private int synergy;
	private String skillName;
	private int keyAbility;
	private GameCharacter character;
	private int points;
	private int miscModifier;

	public Skill(GameCharacter character, int points, int miscModifier) {
		this.character = character;
		this.points = points;
		this.miscModifier = miscModifier;
	}
	
	/**
	 * checks to see if the skill is a class skill
	 * @return true if it is a class skill, false otherwise.
	 */
	public boolean isClassSkill() {
		return false; // TODO
	}
	
	/**
	 * gets the name of the skill.
	 * @return the name of the skill.
	 */
	public String getSkillName() {
		return skillName;
	}
	
	/**
	 * gets the key ability of the skill
	 * @return the ability that is key to the skill.
	 */
	public int getKeyAbility() {
		return keyAbility;
	}
	
	/**
	 * gets the ability modifier for the skill
	 * @return the ability modifier
	 */
	public int getAbilityModifier() {
		int mod = character.getAbilityScores().getAbilityScore(keyAbility);
		return AbilityScores.calculateMod(mod);
	}
	
	/**
	 * gets the max number of ranks you can put into this skill.
	 * @return the max number of ranks.
	 */
	public int getRanks() {
		if (isClassSkill()) return points;
		else return (points / 2);
	}

	/**
	 * sets the synergy bonus for the skill.
	 * @param synergy the bonus to be added to the skill.
	 */
	public void setSynergy(int synergy) {
		this.synergy = synergy;
	}
	
	/**
	 * gets the total miscellaneous modifier for the skill
	 * @return the total miscellaneous modifier.
	 */
	public int getMiscModifier() {
		return miscModifier + synergy;
	}

}