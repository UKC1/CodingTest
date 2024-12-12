import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int S;
    static int[] numbers;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        cnt = 0;
        dfs(0, 0, 0);
        System.out.print(cnt);
    }

    static void dfs(int idx, int sum, int start) {
        if (idx != 0 && sum == S) {
            cnt++;
        }

        if (idx >= N) {
            return;
        }

        for (int i = start; i < N; i++) {
            dfs(idx + 1, sum + numbers[i], i + 1);
        }

    }
}