import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] maps;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maps = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                maps[i][j] = str.charAt(j) - '0';
            }
        }

        // 1 x 1 ~ min(N, M) x min(N, M) 탐색
        // 꼭지점 4개 값이 같으면 ok
        int maxLen = Math.max(N, M);
        int maxSquare = 1;
        loop : for (int len = maxLen; len >= 2; len--) {
            // 시작점들 집합
            for (int x = 0; x <= N - len; x++) {
                for (int y = 0; y <= M - len; y++) {
                    int standard = maps[x][y];
                    if (maps[x][y + len - 1] == standard && maps[x + len - 1][y + len - 1] == standard && maps[x + len - 1][y] == standard) {
                        maxSquare = Math.max(maxSquare, len * len);
                        break loop;
                    }
                }
            }
        }
        System.out.print(maxSquare);

    }
}
