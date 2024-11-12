import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] desserts;
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, -1, 1};
    static boolean[][] visited;
    static boolean[] eaten;
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
            eaten = new boolean[101];  
            for (int i = 0; i < N - 1; i++) {
                for (int j = 1; j < N - 1; j++) {
                    visited = new boolean[N][N];
                    visited[i][j] = true;
                    eaten[desserts[i][j]] = true;
                    dfs(1, i, j, i, j, 0);
                    eaten[desserts[i][j]] = false;
                }
            }
            sb.append('#').append(test_case).append(' ').append(maxCnt).append('\n');
        }
        System.out.print(sb);
    }
    private static void dfs(int cnt, int x, int y, int startX, int startY, int direction) {
        for (int i = direction; i < direction + 2; i++) {
            if (i >= 4) break;
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (nx == startX && ny == startY && cnt >= 4) {
                    maxCnt = Math.max(maxCnt, cnt);
                    return;
                }

                int eatDessert = desserts[nx][ny];
                if (!visited[nx][ny] && !eaten[eatDessert]) {
                    visited[nx][ny] = true;
                    eaten[eatDessert] = true; 
                    dfs(cnt + 1, nx, ny, startX, startY, i);
                    visited[nx][ny] = false;
                    eaten[eatDessert] = false;
                }
            }
        }
    }
}