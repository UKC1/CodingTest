import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Route {
        int x;
        int cnt;

        Route(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }

        public int getCnt() {
            return cnt;
        }

        public int getX() {
            return x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Route> pq1 = new PriorityQueue<>(Comparator.comparingInt(Route::getCnt).thenComparingInt(Route::getX));
        PriorityQueue<Route> pq2 = new PriorityQueue<>(Comparator.comparingInt(Route::getCnt).thenComparingInt(Route::getX));
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(st.nextToken());
            pq1.offer(new Route(i, value));
            map1.put(i, value);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            int value = Integer.parseInt(st.nextToken());
            pq2.offer(new Route(i + N, value));
            map2.put(i + N, value);
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);

            if (cmd == 'U') {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if (x > N) {
                    // Update group 2
                    map2.put(x, y);
                    pq2.offer(new Route(x, y));
                } else {
                    // Update group 1
                    map1.put(x, y);
                    pq1.offer(new Route(x, y));
                }
            } else {
                // Find smallest valid values
                while (!pq1.isEmpty() && map1.get(pq1.peek().x) != pq1.peek().cnt) {
                    pq1.poll(); // Remove outdated value
                }
                while (!pq2.isEmpty() && map2.get(pq2.peek().x) != pq2.peek().cnt) {
                    pq2.poll(); // Remove outdated value
                }

                sb.append(pq1.peek().x).append(' ').append(pq2.peek().x).append('\n');
            }
        }

        System.out.print(sb);
    }
}