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
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String binaryM = Integer.toBinaryString(M);
            for (int i = binaryM.length() - 1; i >= 0; i--) {
                if (N > 0 && binaryM.charAt(i) == '1') {
                    N--;
                } else {
                    break;
                }
            }
            sb.append("#").append(test_case).append(" ").append(N == 0 ? "ON" : "OFF").append("\n");
        }
        System.out.print(sb);
    }

}