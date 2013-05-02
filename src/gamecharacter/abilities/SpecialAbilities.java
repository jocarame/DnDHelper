package gamecharacter.abilities;

public interface SpecialAbilities {
	
	/**
	 * get the name of the special ability.
	 * @return the name of the special ability.
	 */
	public String abilityName();
	
	/**
	 * gets the description of the special ability.
	 * @return the description of the special ability.
	 */
	public String abilityDescription();

	/* apply benefit to character */
	public void benefit();

}