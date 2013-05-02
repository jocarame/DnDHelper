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

import java.util.List;

/**
 * The GameCharacter interface imposes a list of methods that the Printer requires for printing characters on each class that implements it.
 * 
 * @author Justin Kaufman
 * @since 2013-03-25
 */
public interface GameCharacter {

	/**
	 * Gets the character's ability scores.
	 * @return the character's ability scores
	 */
	public AbilityScores getAbilityScores();

	/**
	 * Gets the character's hit points.
	 * @return the character's hit points
	 */
	public int getHitPoints();

	/**
	 * Gets the character's base speed.
	 * @return the character's base speed
	 */
	 public int getSpeed();

	 /**
	  * Gets the character's class.
	  * @return the character's class
	 **/
	 public String getClassType();
	/**
	 * Gets the character's race
	 * @return the character's race
	 **/
	 public String getRace();

	/**
	 * Gets the character's size.
	 * @return the character's size
	 */
	public Size getSize();

	/**
	 * Gets the character's armor class.
	 * @return the character's armor class
	 */
	public ArmorClass getArmorClass();

	/**
	 * Gets a list of any damage reductions the character has.
	 * @return a list of the character's damage reductions
	 */
	public List<DamageReduction> getDamageReductions();

	/**
	 * Gets the character's initiative.
	 * @return the character's initiative
	 */
	public Initiative getInitiative();

	/**
	 * Get the character's Fortitude saving throw.
	 * @return the character's Fortitude saving throw
	 */
	public SavingThrow getFortitudeSavingThrow();

	/**
	 * Gets the character's Reflex saving throw.
	 * @return the character's Reflex saving throw
	 */
	public SavingThrow getReflexSavingThrow();

	/**
	 * Gets the character's Will saving throw.
	 * @return the character's Will saving throw
	 */
	public SavingThrow getWillSavingThrow();

	/**
	 * Gets the character's base attack bonus.
	 * @return the character's base attack bonus
	 */
	public int getBaseAttackBonus();

	/**
	 * Gets the character's spell resistance.
	 * @return the character's spell resistance
	 */
	public int getSpellResistance();

	/**
	 * Gets the character's grapple check.
	 * @return the character's grapple check
	 */
	public Grapple getGrapple();

	/**
	 * Gets a list of the character's skills.
	 * @return a list of the character's skills
	 */
	public List<Skill> getSkills();

	public int getExperiencePoints();
	
	/**
	 * gets the level of the character.
	 * @return the level of the character.
	 */
	public int getLevel();

	public List<Weapon> getWeapons();
	public Armor getArmor();
	public Shield getShield();
	public List<ProtectiveItem> getProtectiveItems();

	public List<Equipment> getOtherPossessions();
	public Load getLoads();

	public Money getMoney();

	/**
	 * gets a list of feats that are applied to this character.
	 * @return the list of feats for this character.
	 */
	public List<Feat> getFeats();
	
	public List<SpecialAbilities> specialAbilities();

	public List<String> getLanguages();

	/**
	 * gets the list of spells available for this character.
	 * @return the list of spells available.
	 */
	public List<Spell> getSpells();

}