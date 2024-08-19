import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int[] pPoint = numToPoint(p);
			int[] qPoint = numToPoint(q);
			int x = pPoint[0] + qPoint[0];
			int y = pPoint[1] + qPoint[1];
			sb.append("#").append(test_case).append(" ").append(pointToNum(new int[] {x, y})).append("\n");
		}
		System.out.print(sb);
	}

	public static int[] numToPoint(int num) {
		int cnt = 0;
		int sum = 2;
		int x = 0;
		int y = 0;
		while (true) {
			for (int i = 1; i < sum; i++) {
				x = i;
				y = sum - i;
				cnt++;
				if (cnt == num) {
					return new int[] {x, y};
				}
			}
			sum++;
		}
	}

	public static int pointToNum(int[] point) {
		int cnt = 0;
		int sum = 0;
		while(true) {
			for (int i = 1; i < sum; i++) {
				int x = i;
				int y = sum - i;
				cnt++;
				if (x == point[0] && y == point[1]) {
					return cnt;
				}
			}
			sum++;
		}
	}
}