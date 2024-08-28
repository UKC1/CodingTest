import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 3) {
                for (int j = 4; j <= num; j++) {
                    dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
                }
                sb.append(dp[num]);
            } else {
                sb.append(dp[num]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }


}