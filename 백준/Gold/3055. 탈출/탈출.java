import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R;
	static int C;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static char[][] maps;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		maps = new char[R][C];
		Queue<int[]> gosum = new ArrayDeque<>();
		Queue<int[]> waters = new ArrayDeque<>();
		visited = new boolean[R][C];
		int endX = 0;
		int endY = 0;
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				char c = str.charAt(j);
				maps[i][j] = c;
				if (c == 'D') {
					endX = i;
					endY = j;
				} else if (c == 'S') {
					gosum.offer(new int[] {i, j, 0});
					visited[i][j] = true;
				} else if (c == '*') {
					waters.offer(new int[] {i, j});
					visited[i][j] = true;
				} else if (c == 'X') {
					visited[i][j] = true;
				}
			}
		}
		int minTime = bfs(endX, endY, gosum, waters);
		System.out.print(minTime == -1 ? "KAKTUS" : minTime);
		
	}	
	
	static int bfs(int endX, int endY, Queue<int[]> gosum, Queue<int[]> waters) {
		while(!gosum.isEmpty()) {
			int waterSize = waters.size();
			for (int i = 0; i < waterSize; i++) {
				int[] currentWater = waters.poll();
				int wx = currentWater[0];
				int wy = currentWater[1];
				
				for (int j = 0; j < 4; j++) {
					int nwx = wx + dx[j];
					int nwy = wy + dy[j];
					if (nwx >= 0 && nwx < R && nwy >= 0 && nwy < C && !visited[nwx][nwy] && maps[nwx][nwy] == '.') {
						visited[nwx][nwy] = true;
						waters.offer(new int[] {nwx, nwy});
					}
				}
			}
			
			int gosumSize = gosum.size();
			for (int i = 0; i < gosumSize; i++) {
				
				int[] currentGosum = gosum.poll();
				
				int x = currentGosum[0];
				int y = currentGosum[1];
				int time = currentGosum[2];
				
				if (x == endX && y == endY) {
					return time;
				}
				
				for (int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					if (nx >= 0 && nx < R && ny >=0 && ny < C && !visited[nx][ny] && (maps[nx][ny] == '.' || maps[nx][ny] == 'D')) {
						visited[nx][ny] = true;
						gosum.offer(new int[] {nx, ny, time + 1});
					}
				}
			}
		}
		return -1;
	}
}