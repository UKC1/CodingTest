import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            char[][] arr = new char[N][N];
            for (int i = 0; i < N; i++) {
                arr[i] = br.readLine().toCharArray();
            }

            int benefit = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (Math.abs(i - N / 2) + Math.abs(j - N / 2) <= N / 2) {
                        benefit += arr[i][j] - '0';
                    }
                }
            }
            System.out.println("#" + test_case + " " + benefit);
        }
    }
}