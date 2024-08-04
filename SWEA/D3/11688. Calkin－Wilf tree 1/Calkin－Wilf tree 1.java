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
			char[] arr = br.readLine().toCharArray();
			int nominator = 1;
			int denominator = 1;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 'R') {
					nominator += denominator;
				} else {
					denominator += nominator;
				}
			}
			System.out.println("#" + test_case + " " + nominator + " " + denominator);
		}
	}
}