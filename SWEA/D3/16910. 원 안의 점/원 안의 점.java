import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;
            for (int x = -N; x <= N; x++) {
                for (int y = -N; y <= N; y++) {
                    if (x * x + y * y <= N * N) {
                        cnt++;
                    }
                }
            }
            System.out.println("#" + test_case + " " + cnt);
        }
    }
}