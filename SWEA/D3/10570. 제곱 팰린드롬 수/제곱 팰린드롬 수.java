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
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int cnt = 0;
			for (int i = A; i <= B; i++) {
				if (isSquare(i) && isPalindrome(i) && isPalindrome((int)Math.sqrt(i))) {
					cnt++;
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		}
	}
	
	public static boolean isSquare(int num) {
		int sqrt = (int)Math.sqrt(num);
		return sqrt * sqrt == num;
	}

	public static boolean isPalindrome(int num) {
		String str = Integer.toString(num);
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}