import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = scan.nextInt();
			int N = scan.nextInt();
			int M = scan.nextInt();
			int result = power(N, M);
			System.out.println("#" + test_case + " " + result);
		}
		scan.close();
	}

	public static int power(int base, int exponent) {
		if (exponent == 0) {
			return 1;
		}
		if (exponent == 1) {
			return base;
		}
		int halfPower = power(base, exponent / 2);
		if (exponent % 2 == 0) {
			return halfPower * halfPower;
		} else {
			return halfPower * halfPower * base;
		}
	}
}