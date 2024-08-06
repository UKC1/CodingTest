import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][M];

            int maxSum = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int rowSum = 0;
                for (int j = 0; j < M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    rowSum += arr[i][j];
                }
                if(maxSum < rowSum) maxSum = rowSum;
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                int rowSum = 0;
                for (int j = 0; j < M; j++) {
                    rowSum += arr[i][j];
                }
                if(maxSum == rowSum) cnt++;
            }
            System.out.println("#" + test_case + " " + cnt + " " + maxSum);
        }
    }
}