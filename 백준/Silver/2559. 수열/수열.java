import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int maxSum = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] culNums = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            culNums[i] = Integer.parseInt(st.nextToken());
            culNums[i] += culNums[i - 1];
        }

        for (int i = 0; i <= N - K; i++) {
            if (culNums[K + i] - culNums[i] > maxSum) {
                maxSum = culNums[K + i] - culNums[i];
            }
        }
        System.out.print(maxSum);
    }
}