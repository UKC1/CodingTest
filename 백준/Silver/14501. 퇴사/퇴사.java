import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int maxProfit;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[][] works = new int[N][2];
        maxProfit = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            works[i][0] = Integer.parseInt(st.nextToken());
            works[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(works, 0, 0);
        System.out.print(maxProfit);
    }

    static void dfs(int[][] works, int time, int sum) {
        if (time >= N) {
            if (sum > maxProfit) maxProfit = sum;
            return;
        }

        dfs(works, time + 1, sum);

        if (time + works[time][0] <= N) {
            dfs(works, time + works[time][0], sum + works[time][1]);
        }
    }
}