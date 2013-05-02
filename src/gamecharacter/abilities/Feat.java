package gamecharacter.abilities;

import java.util.List;

public interface Feat {
	
	/**
	 * gets the name of the feat.
	 * @return the name of the feat.
	 */
	public String getFeatName();
	
	/**
	 * gets the list of prerequisites for a feat.
	 * @return the list of prerequisites.
	 */
	public List<Feat> getFeatPrerequisites(String feat);
	
	/**
	 * benefits that the feat gives the character.
	 * @return the benefits from the feat.
	 */
	public String getBenefits();

	public void benefits(); /* apply benefits to character */

}
