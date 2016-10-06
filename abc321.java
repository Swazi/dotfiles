import java.util.*;

public class Test {

	public static void main(String[] args) {
		//methodMadness();
		//twentyOne();
		//insipid();
		//squareRoot();
		rodentia();
	}
	
	private static void methodMadness() {
		for (int i = 0; i < 100; i++) {
			System.out.println("There is a method to this madness.");
		}
	}
	
	private static void twentyOne() {
		Scanner input = new Scanner(System.in);
		
		int playerScore = 0;
		
		while (playerScore <= 21) {
			System.out.println("Enter 1 to roll 2 to quit.");
			int rollAgain = input.nextInt();
			
			if (rollAgain == 2) {
				break;
			}
			
			int roll = (int)(Math.random()*6) + 1;
			
			if (playerScore < 14) {
				roll += (int)(Math.random()*6) + 1;
			}
			
			playerScore += roll;
			
			System.out.println("Your roll is: " + roll + ". Score: " + playerScore);		
		}	
		
		if (playerScore > 21) {
			System.out.println("Sorry you lose");
			return;
		}
		
		System.out.println("Computer's turn.");
		
		int computerScore = 0;
		
		while (computerScore < 22 && computerScore <= playerScore) {
			
			int roll = (int)(Math.random()*6) + 1;
			
			if (computerScore < 14) {
				roll += (int)(Math.random()*6) + 1;
			}
			computerScore += roll;
			System.out.println("Computer roll is: " + roll + ". Score: " + computerScore);			
		}
		
		if (computerScore < 22) {
			System.out.println("The computer wins!");
		} else {
			System.out.println("You win!");
		}
		
		System.out.println("Play again? Enter 1 for yes.");
		if (input.nextInt() == 1) {
			twentyOne();
		}
	}
	
	public static void insipid() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a number between 1 and 99");
		int numberToCheck = input.nextInt();
		
		if (! (numberToCheck >= 1 && numberToCheck <= 99)) {
			System.out.println("Please enter a valid number");
			return;
		}
		
		while (numberToCheck != 1 && numberToCheck != 58) {
			int sumOfSquares = 0;
			while (numberToCheck > 0) {
				int digit = numberToCheck % 10;
				sumOfSquares += (digit * digit);
				numberToCheck = numberToCheck / 10;
				
			}
			System.out.print(sumOfSquares + " ");
			numberToCheck = sumOfSquares;
		}
		
		System.out.println("");
		if (numberToCheck == 1) {
			System.out.println("insipid");
		} else {
			System.out.println("not insipid");
		}
		
		System.out.println("Enter 1 to go again: ");
		int goAgain = input.nextInt();
		if (goAgain == 1) {
			insipid();
		}
	}
	
	public static void squareRoot() {
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number to find the square root of: ");
		int value = input.nextInt();
		if (value < 0) {
			System.out.println("Please enter a non negative value");
			return;
		}
		System.out.println("Enter your guess");
		double guess = input.nextDouble();
		
		while (true) {
			double newGuess = (guess + value/guess)/2;
			System.out.println(guess);
			if (Math.abs(newGuess - guess) < .00001) {
				break;
			}
			guess = newGuess;
		}
	}
	
	static int nuts;
	
	public static void rodentia() {
		nuts = 10;
		
		while (nuts > 0) {
			int bet = getBet();
			if (bet == 0) {
				break;
			}
			int die1 = rollDie();
			int die2 = rollDie();
			int die3 = rollDie();
			
			System.out.print("Rolling dice! D1: ");
			faceToScreen(die1);
			System.out.print(" D2: ");
			faceToScreen(die2);
			System.out.print(" D3: ");
			faceToScreen(die3);
			System.out.println();
			
			nuts -= bet;
			int gain = computeNutPayout(die1, die2, die3, bet);
			System.out.println("You bet " + bet + " nuts and won " + gain + " nuts for a net of: " + (gain - bet) + " nuts!");
			nuts += gain;
		}
	}
	
	private static int rollDie() {
		return (int)(Math.random()*6) + 1;
	}
	
	private static void faceToScreen(int face) {
		switch(face) {
		case 1: System.out.print("MERCURY"); break;
		case 2: System.out.print("VENUS"); break;
		case 3: System.out.print("EARTH"); break;
		case 4: System.out.print("MARS"); break;
		case 5: System.out.print("JUPITER"); break;
		case 6: System.out.print("SUN"); break;
		}
	}
	
	private static int getBet() {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome squirrel!  You have " + nuts + " nuts.  How many would you like to throw up in the air (0 to quit)?");
		return input.nextInt();
	}
	
	private static int computeNutPayout(int die1, int die2, int die3, int bet) {
		int val;
		if (die1 == 6 && die2 == 6 & die3 == 6) {
			return bet + 128;
		} else if (die1 == 5 && die2 == 5 && die3 >= 5) {
			return bet + 64;
		} else if (die1 == 4 && die2 == 4 && (die3 == 4 || die3 == 6)) {
			return bet + 32;
		} else if (die1 == 3 && die2 == 3 && (die3 == 3 || die3 == 6)) {
			return bet + 16;
		} else if (die1 == 1 && die2 == 1 && die3 == 1) {
			return bet + 8;
		} else if (die1 == 1 && die2 == 1) {
			return bet + 4;
		} else if (die1 == 1) {
			return bet + 2;
		} else {
			return 0;
		}		
	}
}
