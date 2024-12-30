import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        char[][] maps = new char[N][N];
        char[][] redGreenMaps = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = str.charAt(j);
                maps[i][j] = c;
                redGreenMaps[i][j] = c == 'R' ? 'G' : c;
            }
        }

        int totalCnt = 0;
        int cnt = 0;
        boolean[][] visited1 = new boolean[N][N];
        boolean[][] visited2 = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited1[i][j]) {
                    dfs(i, j, visited1, maps);
                    totalCnt++;
                }

                if (!visited2[i][j]) {
                    dfs(i, j, visited2, redGreenMaps);
                    cnt++;
                }
            }
        }
        System.out.print(totalCnt + " " + cnt);

    }

    static void dfs(int x, int y, boolean[][] visited, char[][] maps) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && maps[nx][ny] == maps[x][y]) {
                dfs(nx, ny, visited, maps);
            }
        }
    }
}