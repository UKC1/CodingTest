import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	static Set<String> set = new HashSet<>();

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N= Integer.parseInt(br.readLine());
			boolean[][] visited = new boolean[N][N];
			int[][] map = new int[N][N];
			dfs(0, N, visited, 0, map);
			sb.append("#").append(test_case).append(" ").append(set.size()).append("\n");
			set.clear();
		}
		System.out.print(sb);
	}

	static void dfs(int row, int N, boolean[][] visited, int queenCnt, int[][] map) {
		if (queenCnt == N) {
			String mapString= mapToString(map);
			if (!set.contains(mapString)) {
				set.add(mapString);
			}
			return;
		}

		for (int col = 0; col < N; col++) {
			if (!visited[row][col]) {
				// 현재 상태를 저장
				boolean[][] originalVisited = deepCopy(visited);
				int[][] originalMap = deepCopy(map);

				// 새로운 퀸 배치
				map[row][col] = 1;
				visited = queenTouch(row, col, visited);

				// 다음 행으로 재귀 호출
				dfs(row + 1, N, visited, queenCnt + 1, map);

				// 상태 복원
				visited = originalVisited;
				map = originalMap;
			}
		}
	}

	static String mapToString(int[][] map) {
		StringBuilder sb=new StringBuilder();
		for (int[] row : map) {
			for (int val : row) {
				sb.append(val);
			}
			sb.append('/');
		}
		return sb.toString();
	}

	static boolean[][] queenTouch(int x, int y, boolean[][] visited) {
		visited[x][y] = true;
		for (int n = 1; n < visited.length; n++) {
			for (int i =0; i < 8; i++) {
				int nx = x + dx[i] * n;
				int ny= y + dy[i] * n;
				if (nx >= 0 && nx < visited.length && ny >= 0 && ny < visited.length) {
					visited[nx][ny] = true;
				}
			}
		}
		return visited;
	}

	// 배열의 깊은 복사본 생성
	static boolean[][] deepCopy(boolean[][] original) {
		if (original == null) return null;
		boolean[][] result = new boolean[original.length][];
		for (int i = 0; i < original.length; i++) {
			result[i] = original[i].clone();
		}
	return result;
}

	static int[][] deepCopy(int[][] original) {
		if (original == null) return null;
		int[][] result = new int[original.length][];
		for (int i=0; i < original.length; i++) {
			result[i] = original[i].clone();
		}
		return result;
	}
}