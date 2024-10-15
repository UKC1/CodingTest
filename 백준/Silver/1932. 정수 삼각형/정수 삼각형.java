import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 삼각형 크기 입력
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N]; // 현재 줄의 경로 합
        int[] prev = new int[N]; // 이전 줄의 경로 합

        // 삼각형의 첫 줄 입력
        dp[0] = Integer.parseInt(br.readLine());

        // 두 번째 줄부터 입력받아 경로 계산
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            // 이전 dp 값을 prev 배열에 복사
            System.arraycopy(dp, 0, prev, 0, i);

            // 현재 줄의 첫 번째 값은 이전 줄의 첫 번째 값과 더함
            dp[0] = prev[0] + Integer.parseInt(st.nextToken());

            // 중간 값들 처리
            for (int j = 1; j < i; j++) {
                dp[j] = Math.max(prev[j - 1], prev[j]) + Integer.parseInt(st.nextToken());
            }

            // 현재 줄의 마지막 값은 이전 줄의 마지막 값과 더함
            dp[i] = prev[i - 1] + Integer.parseInt(st.nextToken());
        }

        // dp 배열에서 최대값 찾기
        int maxSum = 0;
        for (int i = 0; i < N; i++) {
            maxSum = Math.max(maxSum, dp[i]);
        }

        System.out.print(maxSum);  // 최대 경로 출력
    }
}