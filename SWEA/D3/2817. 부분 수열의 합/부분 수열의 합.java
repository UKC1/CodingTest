import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] numbers = new int[N];
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;

            // 1 << N 은 2^N을 의미함. 0부터 2^N - 1까지 모든 경우의 수를 탐색
            for (int i = 1; i < (1 << N); i++) {
                int sum = 0;
                // i를 비트마스크로 사용
                for (int j = 0; j < N; j++) {
                    // i의 j번째 비트가 1이면 numbers[j]를 포함
                    if ((i & (1 << j)) != 0) {
                        sum += numbers[j];
                    }
                }
                if (sum == K) {
                    cnt++;
                }
            }

            sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}