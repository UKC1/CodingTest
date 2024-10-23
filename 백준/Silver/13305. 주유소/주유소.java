import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] dist = new int[N - 1];
        int[] cost = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        long minCost = 0;
        int currentPos = 0;
        while(currentPos < N - 1) {

            int currentCost = cost[currentPos];
            int nextPos = -1;
            for (int i = currentPos + 1; i < N; i++) {
                if (currentCost > cost[i]) {
                    nextPos = i;
                    break;
                }
            }

            if (nextPos == -1) {
                long distSum = 0;
                for (int i = currentPos; i < N - 1; i++) {
                    distSum += dist[i];
                }
                minCost += distSum * currentCost;
                break;
            }

            long distSum = 0;
            for (int i = currentPos; i < nextPos; i++) {
                distSum += dist[i];
            }
            minCost += distSum * currentCost;
            currentPos = nextPos;
        }
        System.out.print(minCost);
    }
}