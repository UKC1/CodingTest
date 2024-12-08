import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] rooms;
    static int maxProfit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        rooms = new int[N][2];
        maxProfit = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            rooms[i][0] = Integer.parseInt(st.nextToken());
            rooms[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.print(maxProfit);
    }

    static void dfs(int day, int sum) {
        if (day >= N) {
            maxProfit = Math.max(maxProfit, sum);
            return;
        }

        if (day + rooms[day][0] <= N) {
            dfs(day + rooms[day][0], sum + rooms[day][1]);
        }
        dfs(day + 1, sum);
    }
}