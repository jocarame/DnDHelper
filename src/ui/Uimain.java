package ui;

import gamecharacter.PCGameCharacter;

import java.util.Scanner;

/**
import dungeon.Dungeon;
import dungeon.Setting;
import dungeonUtil.Difficulty;
import dungeonUtil.Size;
*/
public class Uimain
{

	/**
	public static void generateDungeon(Scanner scan)
	{

			System.out.println("Please Enter a Setting (forest, dungeon, mountain, otherplane, city, ocean)");
			String setting = scan.next();
			setting = setting.toUpperCase();
			Setting set = null;
			int dnum =0;
			if(setting.equals("FOREST")){set = Setting.FOREST;}
			if(setting.equals("DUNGEON")){set = Setting.DUNGEON;}
			if(setting.equals("MOUNTAIN")){set = Setting.MOUNTAIN;}
			if(setting.equals("OTHERPLANE")){set = Setting.OTHERPLANE;}
			if(setting.equals("CITY")){set = Setting.CITY;}
			if(setting.equals("OCEAN")){set = Setting.OCEAN;}
			System.out.println("Please Enter in a size (small, medium, large, huge,)");
			String size = scan.next();
			size = size.toLowerCase();
			Size sizeOfDungeon = new Size(size);
			System.out.println("Please Enter a challange rating for the dungeon (1 - 20)");
			if(scan.hasNextInt())
			{
			dnum= scan.nextInt();
			}
			Difficulty dif = new Difficulty(dnum);
			Dungeon du = new Dungeon(set,sizeOfDungeon,dif);
			System.out.println("Dungeon Created!");
			System.out.println("Please choose an option");

			System.out.println("1 - print dungeon");
			System.out.println("2 - save dungeon"



	}*/
	
	public static PCGameCharacter genCharacter(Scanner scan){
		
		PCGameCharacter gc = new PCGameCharacter();
		
		System.out.println("Please Enter a Class");
		String cl = scan.next();
		gc.setClass(cl);
		System.out.println("Please Enter a Race");
		String r = scan.next();
		gc.setRace(r);
		System.out.println("Please Enter a Level");
		int lvl = scan.nextInt();
		gc.setLevel(lvl);
		
		return gc;
	}

	public static void main(String[] args) {

		PCGameCharacter gc;
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to dndHelper 1.0");
		System.out.println("Choose your selection");
		System.out.println("1 - Character Creator");
		System.out.println("2 - load Character");
		System.out.println("3 - Generate Dungeon");
		System.out.println("4 - load Dungeon");
		
		while(scan.hasNextInt())
		{
			int num = scan.nextInt();
			if(num == 1)
			{
				System.out.println("Please select type of character to create");
				System.out.println("1 - Random Character");
				System.out.println("2 - Build your Own");
				int pick = scan.nextInt();
				if (pick == 1){
					gc = new PCGameCharacter();
				}
				else if (pick == 2){
					gc = genCharacter(scan);
				}
			}
			else if(num == 2)
			{
				System.out.println("Please enter the name of the character to load");
				String name = scan.next();
				PCGameCharacter load = loadCharacter(name);
			}
			else if(num == 3)
			{
				//generateDungeon(scan);
			}
			else if(num == 4)
			{

			}
		}
	}

}