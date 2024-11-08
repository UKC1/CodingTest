import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] maps = new int[N][M];
		int[][] dists = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
				if (maps[i][j] == 2) {
					queue.offer(new int[] {i, j, 1});
					visited[i][j] = true;
				}
			}
		}
				
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];
			int cnt = current[2];
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && maps[nx][ny] == 1) {
					dists[nx][ny] = cnt;
					visited[nx][ny] = true;
					queue.offer(new int[] {nx, ny, cnt + 1});
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && maps[i][j] == 1) {
					sb.append(-1).append(' ');
				} else {
					sb.append(dists[i][j]).append(' ');
				}
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
}