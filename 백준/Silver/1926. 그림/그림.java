import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[][] visited = new boolean[N][M];
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					list.add(dfs(map, i, j, visited));
				}
			}
		}
		list.sort(Collections.reverseOrder());
		System.out.println(list.size());
		System.out.println(list.isEmpty() ? 0 : list.get(0));
	}

	static int dfs(int[][] map, int x, int y, boolean[][] visited) {
		int totalCnt = 1;
		visited[x][y] = true;
		int n = map.length, m = map[0].length;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 1 && !visited[nx][ny]) {
				totalCnt += dfs(map, nx, ny, visited);
			}
		}
		return totalCnt;
	}
}