import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] desserts;
	static int[] dx = {1, 1, -1, -1}; // 우하 좌하 좌상 우상
	static int[] dy = {1, -1, -1, 1};
	static boolean[][] visited;
	static Set<Integer> dessert;
	static int maxCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            desserts = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    desserts[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            maxCnt = -1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                	visited = new boolean[N][N];
                	dessert = new HashSet<>();
                	visited[i][j] = true;
                	dessert.add(desserts[i][j]);
                	dfs(1, i, j, i, j, 0);
                }
            }

            sb.append('#').append(test_case).append(' ').append(maxCnt).append('\n');
        }
        System.out.print(sb);
    }

    private static void dfs(int cnt, int x, int y, int startX, int startY, int direction) {
    	for (int i = direction; i < 4; i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
    			if(nx == startX && ny == startY && cnt > 2) {
    				maxCnt = Math.max(maxCnt, cnt);
    				return;
    			}
    			
    			if (!visited[nx][ny] && !dessert.contains(desserts[nx][ny])) {
    				visited[nx][ny] = true;
    				dessert.add(desserts[nx][ny]);
    				dfs(cnt + 1, nx, ny, startX, startY, i);
    				visited[nx][ny] = false;
    				dessert.remove(desserts[nx][ny]);
    			}
    		}
    	}
    }
}