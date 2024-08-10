import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[][] snailArr = new int[N][N];
			int cnt = 1;
			int row = 0;
			int col = 0;
			int currentDir = 0;
			while(cnt <= N * N) {
				snailArr[row][col] = cnt++;
				int nextRow = row + dx[currentDir];
				int nextCol = col + dy[currentDir];
				if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N && snailArr[nextRow][nextCol] == 0) {
					row = nextRow;
					col = nextCol;
				} else {
					currentDir = (currentDir + 1) % 4;
					row = row + dx[currentDir];
					col = col + dy[currentDir];
				}
			}
			sb.append('#').append(test_case).append('\n');
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(snailArr[i][j]).append(' ');
				}
				sb.append('\n');
			}
		}
		System.out.print(sb);
	}
}