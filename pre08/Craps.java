import java.io.*;
import java.util.*;

public class Craps {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Keener's Casino.  We only play Craps here.\nHow many games would you like to play?");
		int x = input.nextInt();
		for (int i = 1; i <= x; i++) {
			round();
		}
		System.out.println("Thanks for playing! Have a good night!");
	}
	
	public static int roll(int x) {
		return (int)(Math.random()*x)+1;
	}
	
	public static int shoot(int numDice, int maxVal) {
		int shoot = 0;
		for (int i = 0; i<numDice; i++) {
			shoot+=roll(maxVal);
		}
		return shoot;
	}
	
	public static void round() {
		System.out.println("Let's play a round of Craps.");
		int firstRoll = shoot(2,6);
		int point = 0;
		if (firstRoll == 2||firstRoll == 3||firstRoll == 12) {
			System.out.println("Shooter rolled " + firstRoll + ".  That's CRAPS! Game over");
		}
		else if (firstRoll == 7||firstRoll == 11) {
			System.out.println("Shooter rolled " + firstRoll + ". That's a Natural! Winner, winner, chicken dinner!");
		}
		else {
			System.out.println("You rolled " + firstRoll+". That's now the POINT.  Keep rolling until you hit the POINT or a 7.");
			point = firstRoll;
			int roll = shoot(2,6);
			while (roll != 7 && roll != point) {
				System.out.println("You rolled " + roll + ". That's not the POINT or a 7, keep rolling!");
				roll = shoot(2,6);
			}
			if (roll == 7) System.out.println("That's a 7, you lose!");
			if (roll == point) System.out.println("You rolled " + roll +". You hit the POINT, you win!");
		}
	}
}
			
		
	