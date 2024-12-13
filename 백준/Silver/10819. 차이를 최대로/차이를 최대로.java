import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] numbers;
    static int maxSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        maxSum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, new int[N], new boolean[N]);
        System.out.println(maxSum);
    }

    static void dfs(int idx, int[] arr, boolean[] visited) {
        if (idx == N) {
            int sum = sumArr(arr);
            maxSum = Math.max(maxSum, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[idx] = numbers[i];
                dfs(idx + 1, arr, visited);
                visited[i] = false;
            }
        }
    }
    static int sumArr(int[] arr) {
        int sum = 0;
        for (int i = 1; i < N; i++) {
            sum += Math.abs(arr[i] - arr[i - 1]);
        }
        return sum;
    }
}