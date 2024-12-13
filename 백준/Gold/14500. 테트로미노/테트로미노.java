import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] maps;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int maxSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maps = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        maxSum = 0;

        // 모든 셀에서 탐색 시작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, maps[i][j], 1);  // DFS로 4칸 탐색
                visited[i][j] = false;
                checkExtraShapes(i, j);    // 'ㅗ' 모양 체크
            }
        }

        // 결과 출력
        System.out.println(maxSum);
    }

    // DFS로 테트로미노 탐색
    static void dfs(int x, int y, int currentSum, int depth) {
        if (depth == 4) {
            maxSum = Math.max(maxSum, currentSum);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, currentSum + maps[nx][ny], depth + 1);
                visited[nx][ny] = false; // 백트래킹
            }
        }
    }

    // 'ㅗ', 'ㅏ', 'ㅜ', 'ㅓ' 모양 체크
    static void checkExtraShapes(int x, int y) {
        // 'ㅗ' 모양의 상대 좌표
        int[][] shapes = {
                {0, 0, 0, 1, 0, -1, 1, 0},  // ㅗ
                {0, 0, 0, -1, 0, 1, -1, 0}, // ㅓ
                {0, 0, 1, 0, -1, 0, 0, 1},  // ㅜ
                {0, 0, 1, 0, -1, 0, 0, -1}  // ㅏ
        };

        for (int[] shape : shapes) {
            int sum = 0;
            boolean isValid = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + shape[i * 2];
                int ny = y + shape[i * 2 + 1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    sum += maps[nx][ny];
                } else {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                maxSum = Math.max(maxSum, sum);
            }
        }
    }
}