import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] lines = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken()); // A 위치
            lines[i][1] = Integer.parseInt(st.nextToken()); // B 위치
        }

        // A 위치를 기준으로 정렬
        Arrays.sort(lines, Comparator.comparingInt(o -> o[0]));

        // DP 배열 생성
        int[] dp = new int[N];
        Arrays.fill(dp, 1); // 최소한 각 전깃줄은 1개의 수열을 이룰 수 있음

        // 가장 긴 증가하는 부분 수열(LIS) 구하기
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (lines[j][1] < lines[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // LIS 길이 구하기
        int lisLength = 0;
        for (int i = 0; i < N; i++) {
            lisLength = Math.max(lisLength, dp[i]);
        }

        // 최소로 끊어야 하는 전깃줄의 개수 = 전체 전깃줄 개수 - LIS 길이
        System.out.println(N - lisLength);
    }
}