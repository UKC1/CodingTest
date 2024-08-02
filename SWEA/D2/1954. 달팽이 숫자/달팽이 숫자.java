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

			int[] dx = {0, 1, 0, -1};
			int[] dy = {1, 0, -1, 0};
			int currentX = 0, currentY = 0;
			int[][] map = new int[N][N];
			int cnt = 1;
			int row = 0;
			int col = 0;
			int dirCnt = 0;
			while(cnt <= N * N) {
				map[row][col] = cnt;
				int nRow = row + dx[currentX];
				int nCol = col + dy[currentY];
				if (nRow >= 0 && nRow < N && nCol >= 0 && nCol < N && map[nRow][nCol] == 0) {
					row = nRow;
					col = nCol;
					cnt++;
					dirCnt = 0;
				} else {
					currentX = (currentX + 1) % 4;
					currentY = (currentY + 1) % 4;
					dirCnt++;
					if (dirCnt > 1) break;
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