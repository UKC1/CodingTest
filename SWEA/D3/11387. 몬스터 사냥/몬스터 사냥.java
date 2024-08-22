import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            long totalDamage = 0;
            for (int i = 0; i < N; i++) {
                totalDamage +=  D + i * L * D / 100;
            }
            sb.append("#").append(test_case).append(" ").append(totalDamage).append("\n");
        }

        System.out.print(sb);
    }

}