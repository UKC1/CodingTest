import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int sum = 0;
            int alternateNum = 1;
            for (int i = 1; i <= N; i++) {
                sum += i * alternateNum;
                alternateNum *= -1;
            }
            System.out.println("#" + test_case + " " + sum);
        }
    }
}