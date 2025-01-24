import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V;
    static int M;
    static class Place {
        int vertex, time;
        Place(int vertex, int time) {
            this.vertex = vertex;
            this.time = time;
        }

        public int getTime() {
            return time;
        }
    }

    static class Select {
        int timeSum;
        int idx;
        int timeFromJ;
        int diff;
        Select(int timeSum, int timeFromJ, int idx, int diff) {
            this.timeSum = timeSum;
            this.timeFromJ = timeFromJ;
            this.idx = idx;
            this.diff = diff;
        }

        public int getIdx() {
            return idx;
        }

        public int getTimeFromJ() {
            return timeFromJ;
        }

        public int getTimeSum() {
            return timeSum;
        }

        public int getDiff() {
            return diff;
        }

        @Override
        public String toString() {
            return "Select{" +
                    "timeSum=" + timeSum +
                    ", idx=" + idx +
                    ", timeFromJ=" + timeFromJ +
                    '}';
        }
    }

    static List<List<Place>> graph;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<List<Place>>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Place(b, c));
            graph.get(b).add(new Place(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int J = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        // J, S는 새로운 약속장소 X
        // J + S의 최소값
        // J는 S보다 늦게 도착하면 X
        // 여러곳이 있으면 J에게 가장 가까운 곳 중 번호가 가장 작은 곳
        List<Select> selects = new ArrayList<Select>();
        int[] distFromJ = dijkstra(J);
        int[] distFromS = dijkstra(S);

        for (int i = 1; i <= V; i++) {
            if (distFromJ[i] == INF || distFromS[i] == INF || i == S || i == J) continue;
            int timeSum = distFromJ[i] + distFromS[i];
            selects.add(new Select(timeSum, distFromJ[i], i, distFromJ[i] - distFromS[i]));
        }
        selects.sort(Comparator.comparingInt(Select::getTimeSum)
                .thenComparingInt(Select::getTimeFromJ)
                .thenComparingInt(Select::getIdx)
        );
        if (selects.isEmpty() || selects.get(0).getDiff() > 0) {
            System.out.print(-1);
        } else {
            System.out.println(selects.get(0).getIdx());
        }
    }

    static int[] dijkstra(int start) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Place> pq = new PriorityQueue<>(Comparator.comparingInt(Place::getTime));
        pq.offer(new Place(start, 0));
        while (!pq.isEmpty()) {
            Place p = pq.poll();
            int currentV = p.vertex;
            int currentTime = p.time;
            if (dist[currentV] < currentTime) continue;
            for (Place next : graph.get(currentV)) {
                int nextDist = dist[currentV] + next.time;
                if (dist[next.vertex] > nextDist) {
                    dist[next.vertex] = nextDist;
                    pq.offer(new Place(next.vertex, nextDist));
                }
            }
        }
        return dist;
    }
}