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
            int M = Integer.parseInt(st.nextToken());
            String binaryM = Integer.toBinaryString(M);
            boolean isTrue = true;
            while(N > 0) {
                int r = M % 2;
                if (r != 1) {
                    isTrue = false;
                    break;
                }
                M /= 2;
                N--;
            }
            sb.append("#").append(test_case).append(" ").append(isTrue ? "ON" : "OFF").append('\n');
        }
        System.out.print(sb);
    }
}
