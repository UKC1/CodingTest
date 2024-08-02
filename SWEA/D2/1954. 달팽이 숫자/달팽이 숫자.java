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
			int N = Integer.parseInt(br.readLine());
			boolean rightStart = true;
			boolean downStart = false;
			boolean leftStart = false;
			boolean upStart = false;
			
			int[][] map = new int[N][N];
			int cnt = 1;
			int row = 0;
			int col = 0;
			map[0][0] = 1;
			while(cnt < N * N) {

				if (rightStart) {
					int nCol = col + 1;
					if (nCol >= N || map[row][nCol] != 0) {
						rightStart = false;
						downStart = true;
					} else {
						col = nCol;
						map[row][col] = ++cnt;
					}
				}

				if (downStart) {
					int nRow = row + 1;
					if (nRow >= N || map[nRow][col] != 0) {
						downStart = false;
						leftStart = true;
					} else {
						row = nRow;
						map[row][col] = ++cnt;
					}
				}

				if (leftStart) {
					int nCol = col - 1;
					if (nCol < 0 || map[row][nCol] != 0) {
						leftStart = false;
						upStart = true;
					} else {
						col = nCol;
						map[row][col] = ++cnt;
					}
				}

				if (upStart) {
					int nRow = row - 1;
					if (nRow < 0 || map[nRow][col] != 0) {
						upStart = false;
						rightStart = true;
					} else {
						row = nRow;
						map[row][col] = ++cnt;
					}
				}

				if (!rightStart && !downStart && !leftStart && !upStart) {
					break;
				}

			}

			System.out.println("#" + test_case);
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}