import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
           int N = Integer.parseInt(br.readLine());
           boolean isTrue = false;
           for (int i = 1; i * i <= N; i++) {
               if (N % i == 0) {
                   if (N / i <= 9 && i <= 9) {
                       isTrue = true;
                       break;
                   }
               }
           }

           sb.append("#").append(test_case).append(" ").append(isTrue ? "Yes" : "No").append("\n");
        }
        System.out.print(sb);
    }
}