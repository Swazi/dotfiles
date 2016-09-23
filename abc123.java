import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Boolean end = false;
		
		while (!end) {
			System.out.println("Enter two numbers:");
			int first = in.nextInt();
			int second = in.nextInt();
		
			int divisorTotal1 = 0;
			int divisorTotal2= 0;
			int divisor = 1;
			
			while (divisor < first) {
				if (first % divisor == 0) {
					divisorTotal1 = divisorTotal1 + divisor;
				}
				divisor = divisor + 1;
			}
			
			divisor = 1;
			
			while (divisor < second) {
				if (second % divisor == 0) {
					divisorTotal2 = divisorTotal2 + divisor;
				}
				divisor = divisor + 1;
			}
			
			if (divisorTotal1 == second && divisorTotal2 == first) {
				System.out.println(first + " " + second + " are an amicable pair");
			} else {
				System.out.println(first + " " + second + " are not an amicable pair");
			}
			
			System.out.println("Enter 1 to try again anything else will end the program:");
			Integer goAgain = in.nextInt();
			
			if (goAgain != 1) {
				end = true;
			}		
		}	
		System.out.println("Ending...");
		in.close();
	}
}
