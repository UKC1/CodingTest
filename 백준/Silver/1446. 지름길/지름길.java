import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int D;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int[] dp = new int[D + 1];
        for (int i = 0; i < D + 1; i++) {
            dp[i] = i;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[3]));
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{start, end, dist, dist + start});
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int start = cur[0];
            int end = cur[1];
            int dist = cur[2];
            if (end <= D && dp[end] > dist + dp[start]) {
                dp[end] = dist + dp[start];
                for (int num = end + 1; num <= D; num++) {
                    dp[num] = Math.min(dp[num], dp[end] + num - end);
                }
            }
        }
        System.out.print(dp[D]);
    }
}