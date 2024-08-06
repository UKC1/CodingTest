import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            char[][] farm = new char[N][N];
            for (int i = 0; i < N; i++) {
                farm[i] = br.readLine().toCharArray();
            }

            int benefit = 0;
            int mid = N / 2;
            for (int i = 0; i < N; i++) {
                int start = Math.abs(mid - i);
                int end = N - start;
                for (int j = start; j < end; j++) {
                    benefit += farm[i][j] - '0';
                }
            }

            System.out.println("#" + test_case + " " + benefit);
        }
    }
}