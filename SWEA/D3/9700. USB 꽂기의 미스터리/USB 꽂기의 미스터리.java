import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double p = Double.parseDouble(st.nextToken());
			double q = Double.parseDouble(st.nextToken());

			// 첫 번째 시도에서 성공할 확률
			double s0 = p * q;

			// 한 번 뒤집어서 성공할 확률 s1
			double s1 = (1 - p) * q;

			// 두 번 뒤집어서 성공할 확률 s2
			double s2 = p * (1 - q) * q;

			// s1 < s2인지 비교
			System.out.println("#" + test_case + " " + (s1 < s2 ? "YES" : "NO"));
		}
	}
}
