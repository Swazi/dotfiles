import java.util.*;

public class Test {

//	coinflips
//	public static void main(String[] args) {
//
//		int i = 0;
//		int max = 0;
//		int consecutive = 0;
//
//		while (i < 10) {
//			int flip = (int) (Math.random() + .5);
//			System.out.print(flip);
//			if (flip == 0) {
//				consecutive = consecutive + 1;
//				if (consecutive > max) {
//					max = consecutive;
//				}
//			} else {
//				consecutive = 0;
//			}
//
//			i = i + 1;
//		}
//		System.out.println("");
//		System.out.println("Consecutive heads: " + max);
//	}
	
// 	baseball
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		
//		int games = in.nextInt();
//		int n = games / 2;
//		
//		double chance = 1.0;
//		int count = 0;
//		
//		while (count < n) {
//			chance = (chance * (1+(2.0*count)) / (2+(2.0*count)));
//			count = count + 1;
//		}
//		
//		System.out.println(chance);
//		
//	}
	
// 	Number
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		
//		System.out.println("Enter the number to check: ");
//		long number = in.nextLong();
//		int count = 0;
//		int divisor = 10;
//		
//		while (number > 0) {
//			if (number % divisor == 0) {
//				count = count + 1;
//			}
//			number = number / 10;
//			divisor = divisor - 1;	
//		}
//		
//		System.out.println(count);
//	}
	
	
	//RightTriangle
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the size of the right triangle: ");
		int n = in.nextInt();
		
		for (int i = 1; i <= n; i++) {
			for(int x = 1; x <= i; x++) {
				System.out.print('X');
			}
			System.out.println("");
		}
	}
}
