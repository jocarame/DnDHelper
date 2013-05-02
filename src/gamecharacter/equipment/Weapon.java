package gamecharacter.equipment;


public interface Weapon extends Equipment {

	public int getAttackBonus();
	public String getDamage();
	public String getCritical();
	public String getRange();
	public String getType();

}