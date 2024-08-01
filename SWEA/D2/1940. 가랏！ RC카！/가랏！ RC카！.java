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
			int currentSpeed = 0;
			int moveDistance = 0;
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int status = Integer.parseInt(st.nextToken());
				if (status == 2) {
					int minusSpeed = Integer.parseInt(st.nextToken());
					if (currentSpeed < minusSpeed) {
						currentSpeed = 0;
					} else {
						currentSpeed -= minusSpeed;
					}
				} else if (status == 1) {
					int plusSpeed = Integer.parseInt(st.nextToken());
					currentSpeed += plusSpeed;
				}
				moveDistance += currentSpeed;
			}
			System.out.println("#" + test_case + " " + moveDistance);
		}

	}
}