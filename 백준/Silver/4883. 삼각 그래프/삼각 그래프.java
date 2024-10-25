import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] maps;
    static int[][] dp;
    static int testCase;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String str;
        testCase = 0;
        while (!(str = br.readLine()).equals("0")) {
            testCase++;
            N = Integer.parseInt(str);
            maps = new int[N][3];
            dp = new int[N][3];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    maps[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            dp[0][0] = Integer.MAX_VALUE;
            dp[0][1] = maps[0][1];
            dp[0][2] = maps[0][1] + maps[0][2];
            for (int i = 1; i < N; i++) {
            	dp[i][0] = maps[i][0] + Math.min(dp[i-1][0], dp[i-1][1]);
                dp[i][1] = maps[i][1] + Math.min(dp[i-1][0], Math.min(dp[i-1][1], Math.min(dp[i-1][2], dp[i][0])));
                dp[i][2] = maps[i][2] + Math.min(dp[i-1][1], Math.min(dp[i-1][2], dp[i][1]));
            }

            sb.append(testCase).append(".").append(" ").append(dp[N-1][1]).append("\n");
        }
        System.out.print(sb);
    }
}