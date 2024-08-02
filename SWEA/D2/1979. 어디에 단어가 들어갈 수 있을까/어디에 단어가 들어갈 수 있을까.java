import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int maxStickCnt = 0;
			int[] middleStickCheck = new int[K + 2];
			for (int i = 1; i < middleStickCheck.length - 1; i++) {
				middleStickCheck[i] = 1;
			}

			for (int row = 0; row < N; row++) {
				boolean firstRowStick = true;
				boolean firstColStick = true;
				boolean lastColStick = true;
				boolean lastRowStick = true;
				for (int col = 0; col < K; col++) {
					if (arr[row][col] != 1) firstRowStick = false;
					if (arr[row][N - col - 1] != 1) lastRowStick = false;
					if (arr[col][row] != 1) firstColStick = false;
					if (arr[N - col - 1][row] != 1) lastColStick = false;
				}
				if (firstRowStick && arr[row][K] == 0) maxStickCnt++;
				if (firstColStick && arr[K][row] == 0) maxStickCnt++;
				if (lastRowStick && arr[row][N - K - 1] == 0) maxStickCnt++;
				if (lastColStick && arr[N - K - 1][row] == 0) maxStickCnt++;

				for (int col = 0; col <= N - middleStickCheck.length; col++) {
					boolean middleRowStick = true;
					boolean middleColStick = true;
					for (int i = 0; i < middleStickCheck.length; i++) {
						if (arr[row][col + i] != middleStickCheck[i]) {
							middleRowStick = false;
						}

						if (arr[col + i][row] != middleStickCheck[i]) {
							middleColStick = false;
						}
					}
					if (middleRowStick) maxStickCnt++;
					if (middleColStick) maxStickCnt++;
				}
			}
			System.out.println("#" + test_case + " " + maxStickCnt);
		}

	}
}