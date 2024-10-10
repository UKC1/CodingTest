import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int minV;
    static int maxV;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] operators = new int[4];
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        minV = Integer.MAX_VALUE;
        maxV = Integer.MIN_VALUE;
        dfs(operators, numbers, 1, numbers[0]);
        System.out.println(maxV);
        System.out.println(minV);
    }

    static void dfs(int[] operators, int[] numbers, int idx, int sum) {
        if (idx == numbers.length) {
            if (sum < minV) minV = sum;
            if (sum > maxV) maxV = sum;
            return;
        }

        if (operators[0] > 0) {
            operators[0]--;
            dfs(operators, numbers, idx + 1, sum + numbers[idx]);
            operators[0]++;
        }

        if (operators[1] > 0) {
            operators[1]--;
            dfs(operators, numbers, idx + 1, sum - numbers[idx]);
            operators[1]++;
        }

        if (operators[2] > 0) {
            operators[2]--;
            dfs(operators, numbers, idx + 1, sum * numbers[idx]);
            operators[2]++;
        }

        if (operators[3] > 0) {
            operators[3]--;
            dfs(operators, numbers, idx + 1, sum / numbers[idx]);
            operators[3]++;
        }
    }
}