import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 두 문자열 입력 받기
        String sequence1 = br.readLine();
        String sequence2 = br.readLine();

        // DP 배열 선언 (각 문자열 길이 + 1 만큼)
        int[][] dp = new int[sequence1.length() + 1][sequence2.length() + 1];

        for (int i = 1; i <= sequence1.length(); i++) {
            for (int j = 1; j <= sequence2.length(); j++) {
                // 두 문자가 같으면, 이전 값 + 1
                if (sequence1.charAt(i - 1) == sequence2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 다르면, 이전 값 중 큰 값 선택
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.print(dp[sequence1.length()][sequence2.length()]);
    }
}