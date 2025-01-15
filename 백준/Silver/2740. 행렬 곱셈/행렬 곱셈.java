import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 첫 번째 행렬의 행 개수
        int M = Integer.parseInt(st.nextToken()); // 첫 번째 행렬의 열 개수 및 두 번째 행렬의 행 개수

        int[][] firstArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                firstArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 두 번째 행렬의 행 개수 (이미 입력된 값과 동일해야 함)
        int K = Integer.parseInt(st.nextToken()); // 두 번째 행렬의 열 개수
        int[][] secondArr = new int[M][K];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                secondArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 행렬 곱셈 수행
        int[][] multipleArr = new int[N][K];
        for (int i = 0; i < N; i++) { // 첫 번째 행렬의 행
            for (int j = 0; j < K; j++) { // 두 번째 행렬의 열
                for (int k = 0; k < M; k++) { // 곱셈 연산
                    multipleArr[i][j] += firstArr[i][k] * secondArr[k][j];
                }
            }
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                sb.append(multipleArr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}