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
			if (clapCount(test_case) == 0) {
				System.out.print(test_case);
			} else {
				for (int i = 0; i < clapCount(test_case); i++) {
					System.out.print("-");
				}
			}
			System.out.print(" ");
		}
	}

	public static int clapCount(int n) {
		int cnt = 0;
		while (n > 0) {
			if (n % 10 == 3 || n % 10 == 6 || n % 10 == 9) cnt++;
			n /= 10;
		}
		return cnt;
	}
}