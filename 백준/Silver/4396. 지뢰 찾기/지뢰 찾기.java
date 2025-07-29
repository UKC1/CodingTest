import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][N];
        char[][] cntMap = new char[N][N];
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = chars[j];
                cntMap[i][j] = '.';
            }
        }
        boolean isBombed = false;
        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (arr[j] == 'x' && map[i][j] == '.') {
                    cntMap[i][j] = (char) (cntDfs(i, j, map) + '0');
                } else if (arr[j] == 'x' && map[i][j] == '*') {
                    isBombed = true;
                }
            }
        }

        if (isBombed) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '*') {
                        cntMap[i][j] = '*';
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(cntMap[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }


    static int cntDfs(int x, int y, char[][] map) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == '*') {
                cnt++;
            }
        }
        return cnt;
    }
}
