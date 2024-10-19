import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 입력: 물건의 개수 N, 배낭의 최대 무게 W
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        // 물건의 무게와 가치를 저장할 배열
        int[] weights = new int[N];
        int[] values = new int[N];

        // 각 물건의 무게와 가치를 입력받음
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        // DP 테이블 초기화: dp[w]는 무게 w일 때의 최대 가치를 저장
        int[] dp = new int[W + 1];

        // 물건을 하나씩 고려
        for (int i = 0; i < N; i++) {
            // 현재 물건을 배낭에 넣을지 말지 결정
            // dp 테이블을 갱신할 때는 뒤에서부터 갱신해야 함 (w >= weights[i])
            for (int w = W; w >= weights[i]; w--) {
                dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
            }
        }

        // 배낭에 담을 수 있는 최대 가치 출력
        System.out.println(dp[W]);
    }
}