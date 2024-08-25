import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] firstArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                firstArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] secondArr = new int[M][K];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                secondArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] multipleArr = new int[firstArr.length][secondArr[0].length];
        for (int i = 0; i < firstArr.length; i++) {
            for (int j = 0; j < secondArr.length; j++) {
                for (int k = 0; k < secondArr[j].length; k++) {
                    multipleArr[i][k] += firstArr[i][j] * secondArr[j][k];
                }
            }
        }

        for (int i = 0; i < multipleArr.length; i++) {
            for (int j = 0; j < multipleArr[0].length; j++) {
                sb.append(multipleArr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);



    }
}