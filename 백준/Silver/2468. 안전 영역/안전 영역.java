import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] maps;
    static int maxCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        maps = new int[N][N];
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                maxLen = Math.max(maxLen, maps[i][j]);
            }
        }
        maxCnt = 0;
        for (int len = 0; len < maxLen; len++) {
            int[][] copyMap = mapCopy();
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (copyMap[i][j] > len) {
                        copyMap[i][j] = -1;
                        dfs(copyMap, i, j, len);
                        cnt++;
                    }
                }
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        System.out.print(maxCnt);
    }
    static int[][] mapCopy() {
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(maps[i], 0, copy[i], 0, N);
        }

        return copy;
    }
    static void dfs(int[][] copyMap, int x, int y, int len) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && copyMap[nx][ny] > len) {
                copyMap[nx][ny] = -1;
                dfs(copyMap, nx, ny, len);
            }
        }
    }
}