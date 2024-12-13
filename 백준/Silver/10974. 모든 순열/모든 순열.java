import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        arr = new int[N];
        sb = new StringBuilder();
        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int idx) {
        if (idx == N) {
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[idx] = i + 1;
                dfs(idx + 1);
                visited[i] = false;
            }
        }
    }
}