import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] chu;
    static boolean[][] dp;
    static final int MAX_W = 40000; // 가능한 최대 무게
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        chu = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            chu[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[N + 1][MAX_W * 2 + 1]; // dp[i][w] : i개의 추까지 사용하여 w 무게를 만들 수 있는가?
        dp[0][MAX_W] = true; // 초기 상태 (0g 가능)

        // DP 진행
        for (int i = 0; i < N; i++) {
            for (int w = 0; w <= 2 * MAX_W; w++) {
                if (dp[i][w]) { // 이전 단계에서 가능한 무게라면?
                    dp[i + 1][w] = true; // 1. 현재 추를 사용하지 않음
                    if (w + chu[i] <= 2 * MAX_W) dp[i + 1][w + chu[i]] = true; // 2. 오른쪽에 추가
                    if (w - chu[i] >= 0) dp[i + 1][w - chu[i]] = true; // 3. 왼쪽에 추가
                }
            }
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int ball = Integer.parseInt(st.nextToken());
            if (ball > MAX_W) sb.append("N ");
            else if (dp[N][ball + MAX_W]) sb.append("Y ");
            else sb.append("N ");
        }
        
        System.out.println(sb);
    }
}