import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long K = Long.parseLong(st.nextToken());
            
            long ans = 0;
            if (K == 0) {
                // x가 홀수여야 함
                ans = (N + 1) / 2;
            } else {
                // x = 2^K * d (d는 홀수), d <= N / 2^K
                long power = 1;
                for (int i = 0; i < K; i++) {
                    // 2^K가 N보다 커지면 더 이상 조건을 만족하는 수가 없음.
                    if (power > N / 2) {
                        power = N + 1;
                        break;
                    }
                    power *= 2;
                }
                if (power > N) {
                    ans = 0;
                } else {
                    long M = N / power; // d의 최대값
                    ans = (M + 1) / 2;  // 1부터 M까지의 홀수 개수
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}