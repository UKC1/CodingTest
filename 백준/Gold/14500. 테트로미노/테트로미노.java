import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] blocks;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][][] remains = {
            {{0,0},{1,0},{2,0},{1,1}},
            {{0,0},{1,0},{2,0},{1,-1}},
            {{0,0},{0,1},{0,2},{1,1}},
            {{0,0},{0,1},{0,2},{-1,1}}
    };
    static int maxSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        blocks = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                blocks[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[N][M];
        maxSum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, blocks[i][j], visited, 1);
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                check(i, j);
            }
        }
        System.out.print(maxSum);
    }

    static void dfs(int x, int y, int sum, boolean[][] visited, int depth) {
        if (depth == 4) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, sum + blocks[nx][ny], visited, depth + 1);
                visited[nx][ny] = false;
            }
        }
    }

    static void check(int x, int y) {
        for (int[][] remain : remains) {
            boolean flag = true;
            int sum = 0;
            for (int[] r : remain) {
                int nx = x + r[0];
                int ny = y + r[1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    flag = false;
                    break;
                }
                sum += blocks[nx][ny];
            }
            if (flag) {
                maxSum = Math.max(maxSum, sum);
            }
        }
    }
}