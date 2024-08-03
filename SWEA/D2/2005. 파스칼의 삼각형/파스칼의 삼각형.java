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
			int N = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			for (int i = 0; i < arr.length; i++) {
				arr[i][0] = 1;
				arr[i][i] = 1;
			}
			for (int i = 1; i < arr.length; i++) {
				for (int j = 1; j < arr.length; j++) {
					arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
				}
			}

			System.out.println("#" + test_case);
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (arr[i][j] == 0) {
						System.out.print("  ");
					} else {
						System.out.print(arr[i][j] + " ");
					}
				}
				System.out.println();
			}
		}
	}
}