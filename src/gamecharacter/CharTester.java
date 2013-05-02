package gamecharacter;

public class CharTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PCGameCharacter gc = new PCGameCharacter();
		System.out.println("Level " + gc.getLevel());
		System.out.println("Race: " + gc.getRace());
		System.out.println("Class: " + gc.getClassType());
		System.out.println("HP: " + gc.getHitPoints());
		System.out.println("Ability Scores: " + gc.getAbilities().toString());
		System.out.print("Skill Points: " + gc.getSkillPoints());
		System.out.println("    Max Ranks (class/cross-class) " + gc.getMaxRank() + "/" + gc.getMaxRank()/2);
		System.out.println("BAB: " + gc.getBaseAttackBonus());
		
	}

}
