import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		boolean[][] visited = new boolean[N][M];
		System.out.println(bfs(map, visited, 0, 0));

	}

	static int bfs(char[][] map, boolean[][] visited, int x, int y) {
		visited[x][y] = true;
		int n = map.length, m = map[0].length;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x, y, 1});
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			x = current[0];
			y = current[1];
			int cnt = current[2];
			if (x == n - 1 && y == m - 1) {
				return cnt;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && map[nx][ny] == '1') {
					visited[nx][ny] = true;
					queue.offer(new int[] {nx, ny, cnt + 1});
				}
			}
		}
		return 0;
	}
}