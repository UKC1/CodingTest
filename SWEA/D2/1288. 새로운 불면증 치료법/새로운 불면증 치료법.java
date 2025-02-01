import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); 
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine()); 

            int seenDigits = 0; // 비트마스킹을 위한 변수 (0~9 등장 체크)
            int currentNum = 0;
            int cnt = 0;

            while (seenDigits != 1023) {  // 1023(=1111111111)이면 모든 숫자가 등장한 것
                cnt++;
                currentNum = cnt * N;

                int num = currentNum;
                while (num > 0) {
                    seenDigits |= (1 << (num % 10)); // 해당 숫자의 비트 ON
                    num /= 10;
                }
            }

            sb.append('#').append(test_case).append(' ').append(currentNum).append('\n');
        }

        System.out.print(sb);
    }
}