import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;

			for (int i = 0; i < 10; i++) {
				int num = Integer.parseInt(st.nextToken());
				int sum = digitSum(num);
				if (max < sum) max = sum;
				if (min > sum) min = sum;
			}
			System.out.println("#" + test_case + " " + max + " " + min);
		}
	}
	
	public static int digitSum(int num) {
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}
}