import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static final int MOD = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int[][] maps = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken()) % MOD; // 모듈러 연산
            }
        }

        int[][] result = pow(maps, B);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static int[][] pow(int[][] matrix, long exp) {
        if (exp == 1) {
            return matrix;
        }
        int[][] half = pow(matrix, exp / 2);
        half = multiple(half, half);
        if (exp % 2 == 1) {
            half = multiple(half, matrix);
        }
        return half;
    }

    static int[][] multiple(int[][] before, int[][] after) {
        int[][] newMaps = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    newMaps[i][j] = (newMaps[i][j] + before[i][k] * after[k][j]) % MOD;
                }
            }
        }
        return newMaps;
    }
}