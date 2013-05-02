package DnDCharacter;

/*this class will contain all the info for each character and allow parts of the character to be build
 * and added to the character object that is then stored in the database. 
*/
public abstract class Character {
	
	//this will construct a character
	public abstract void genCharacter();
	
	//this will set the class of the character
	public abstract void charClass();
	
	//this class sets the abilities for the character
	public abstract void abilities();
	
	//this class sets or removes feats from the character
	public abstract void feats();	
}
