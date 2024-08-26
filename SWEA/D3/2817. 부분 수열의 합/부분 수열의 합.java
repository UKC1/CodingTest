import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int cnt;
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

            cnt = 0;
            for (int i = 1; i <= N; i++) {
                combination(numbers, new int[i], K, 0, 0);
            }
            sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
        }
        System.out.print(sb);
    }

    static void combination(int[] numbers, int[] newNumbers, int target, int idx, int start) {
        if (idx == newNumbers.length) {
            int sum = 0;
            for (int i = 0; i < newNumbers.length; i++) {
                sum += newNumbers[i];
            }

            if (sum == target) {
                cnt++;
            }
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            newNumbers[idx] = numbers[i];
            combination(numbers, newNumbers, target, idx + 1, i + 1);
        }
    }
}