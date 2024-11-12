import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static char[][] maps;
    static int maxCnt;
    static int cnt;
//    static boolean[] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        maps = new char[R][C];
        for (int i = 0; i < R; i++) {
            maps[i] = br.readLine().toCharArray();
        }
        maxCnt = 0;
        cnt = 0;
        boolean[] visited = new boolean[26];
        visited[maps[0][0] - 'A'] = true;
        dfs(0, 0, visited, 1);
        maxCnt = Math.max(maxCnt, cnt);
        System.out.print(maxCnt);
    }
    static void dfs(int x, int y, boolean[] visited, int totalCnt) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[maps[nx][ny] - 'A']) {
                 visited[maps[nx][ny] - 'A'] = true;
                 dfs(nx, ny, visited, totalCnt + 1);
                 visited[maps[nx][ny] - 'A'] = false;
            } else {
                cnt = Math.max(cnt, totalCnt);
            }
        }
    }
}