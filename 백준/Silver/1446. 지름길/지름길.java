import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int N, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        List<int[]> shortcuts = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            if (end <= D) { // 고속도로 범위를 넘어가는 지름길 제외
                shortcuts.add(new int[]{start, end, dist});
            }
        }

        // dp[i]: i까지 도달하는 최소 비용
        int[] dp = new int[D + 1];
        for (int i = 0; i <= D; i++) {
            dp[i] = i; // 기본 비용 (1씩 이동)
        }

        for (int i = 0; i <= D; i++) {
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1); // 이전 위치에서 1 이동
            }
            // 지름길 갱신
            for (int[] shortcut : shortcuts) {
                int start = shortcut[0];
                int end = shortcut[1];
                int dist = shortcut[2];

                if (i == start) {
                    dp[end] = Math.min(dp[end], dp[start] + dist);
                }
            }
        }

        System.out.println(dp[D]);
    }
}