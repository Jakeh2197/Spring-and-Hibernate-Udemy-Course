import java.util.Random;
import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {
		// system objects
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		
		// game variables
		String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin"};
		int maxEnemyHealth = 75;
		int enemyAttackDamage = 25;
		
		// player variables
		int health = 100;
		int attackDamage = 50;
		int healthPotions = 3;
		int healthPotionHealAmount = 30;
		int healthPotionDropChance = 50;
		int score = 0;
		int critChance = 5;
		
		boolean running = true;
		
		System.out.println("Welcome to The Dungeon!");
		
		GAME:
		while(running) {
			System.out.println("\n----------------------------------------\n");
			
			int enemyHealth = rand.nextInt(maxEnemyHealth);
			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# " + enemy + " appeared! #\n");
			
			while(enemyHealth > 0) {
				System.out.println("\tYour HP: " + health);
				System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
				System.out.println("\n\tWhat would you like to do?");
				System.out.println("\t1. Attack!");
				System.out.println("\t2. Drink health potion!");
				System.out.println("\t3. Run!\n\n\n\n");
				
				String input = in.nextLine();
				
				if(input.equals("1")) {
					int damageDealt = rand.nextInt(attackDamage);
					int damageTaken = rand.nextInt(enemyAttackDamage);
					
					if(rand.nextInt(100) < critChance) {
						damageDealt = damageDealt * 2;
						System.out.println("\t#######################");
						System.out.println("\t##### CITICAL HIT! ####");
						System.out.println("\t#######################");
					}
					
					enemyHealth -= damageDealt;
					health -= damageTaken;
					
					System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage!");
					System.out.println("\t> The " + enemy + " deals " + damageTaken + " damage to you in retaliation!");
					
					if(health < 1) {
						System.out.println("\t> You have taken too much damage, you are too weak to go on!");
						break;
					}
				} 
				else if(input.equals("2")) {
					if(healthPotions > 0 ) {
						health += healthPotionHealAmount;
						healthPotions--;
						
						System.out.println("\t> You drink a health potion recovering " + healthPotionHealAmount + ". \n\t> You now have " + health + " HP.");
						System.out.println("\n\t> You have " + healthPotions + " health potions left.\n");
					}
					else {
						System.out.println("\t> You do not have any health potions left! Defeat enemies for a chance to find one!");
					}
				} 
				else if(input.equals("3")) {
					System.out.println("\t>You run away from the " + enemy + "!");
					continue GAME;
				} 
				else {
					System.out.println("\t>Not a valid option! Please enter 1, 2, or 3");
				}
			}
			
			if(health < 1) {
				System.out.println("You limp out of the dungeon, weak from battle");
				break;
			}
			
			score++;
			
			System.out.println("\n----------------------------------------\n");
			System.out.println(" # " + enemy + " was defeated! #");
			System.out.println(" # You have " + health + " HP left #");
			
			if(rand.nextInt(100) < healthPotionDropChance) {
				healthPotions++;
				System.out.println(" # The " + enemy + " dropped a health potion! #");
			}
			
			System.out.println(" # You have " + healthPotions + " health potion(s). #");
			
			System.out.println("\n----------------------------------------\n");
			System.out.println("What would you like to do?");
			System.out.println("1. Continue fighting!");
			System.out.println("2. Exit the dungeon");
			
			String input = in.nextLine();
			
			while(!input.equals("1") && !input.equals("2")) {
				System.out.println("\t>Not a valid option! Please enter 1 or 2");
				input = in.nextLine();
			}
			
			if(input.equals("1")) {
				System.out.println("You continue deeper into the dungeon!");
			}
			else if (input.equals("2")) {
				System.out.println("You exit the dungeon, successful from your adventures!\n");
				break;
			}
			
		}
		
		System.out.println("#######################");
		System.out.println("# Thanks for playing! #");
		
		if(score > 9) {
			System.out.println("#   You scored: " + score + "    #");
		}
		else {
			System.out.println("#    You scored: " + score + "    #");
		}
		
		System.out.println("#######################");
		in.close();
	}
}