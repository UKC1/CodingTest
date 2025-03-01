import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] memory;
    static int[] cost;
    static int minCost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        memory = new int[N];
        cost = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        minCost = Integer.MAX_VALUE;
        int maxCost = Arrays.stream(cost).sum();
        int[] dp = new int[maxCost + 1];
        for (int i = 0; i < N; i++) {
            for (int j = maxCost; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
            }
        }

        for (int j = 0; j <= maxCost; j++) {
            if (dp[j] >= M) {
                minCost = j;
                break;
            }
        }
        System.out.println(minCost);
    }
}