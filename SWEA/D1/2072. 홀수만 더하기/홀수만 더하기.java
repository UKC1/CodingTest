import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int oddSum = 0;
			for (int i = 0; i < 10; i++) {
				int num = Integer.parseInt(st.nextToken());
				if (num % 2 != 0) oddSum += num;
			}
			System.out.printf("#%d %d\n", test_case, oddSum);
		}
	}
}
