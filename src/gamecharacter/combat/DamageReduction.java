package gamecharacter.combat;

public class DamageReduction {

	private int damageIgnored;
	private String vulnerableTypes;


	public DamageReduction(int damageIgnored, String vulnerableTypes) {
		this.damageIgnored = damageIgnored;
		this.vulnerableTypes = vulnerableTypes;
	}

	public int getDamagedIgnored() {
		return damageIgnored;
	}
	public String getVulnerableTypes() {
		return vulnerableTypes;
	}

}
