import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long[] dp = new long[1001];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
        	dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        System.out.print(dp[N] % 10007);
	} 
}