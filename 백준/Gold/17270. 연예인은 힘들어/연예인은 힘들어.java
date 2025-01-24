import java.io.*;
import java.util.*;

public class Main {
    static int V, M;
    static final int INF = (int) 1e9;

    static class Place {
        int vertex, time;
        Place(int vertex, int time) {
            this.vertex = vertex;
            this.time = time;
        }
    }

    static List<List<Place>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
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

        int[] distFromJ = dijkstra(J);
        int[] distFromS = dijkstra(S);

        int result = findMeetingPlace(distFromJ, distFromS, J, S);
        System.out.println(result);
    }

    static int[] dijkstra(int start) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Place> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.time));
        pq.offer(new Place(start, 0));

        while (!pq.isEmpty()) {
            Place current = pq.poll();
            if (dist[current.vertex] < current.time) continue;

            for (Place next : graph.get(current.vertex)) {
                int nextDist = dist[current.vertex] + next.time;
                if (dist[next.vertex] > nextDist) {
                    dist[next.vertex] = nextDist;
                    pq.offer(new Place(next.vertex, nextDist));
                }
            }
        }

        return dist;
    }

    static int findMeetingPlace(int[] distFromJ, int[] distFromS, int J, int S) {
        int minTimeSum = INF, minDistFromJ = INF, result = -1;

        for (int i = 1; i <= V; i++) {
            // S나 J는 제외, 도달할 수 없는 곳도 제외
            if (i == J || i == S || distFromJ[i] == INF || distFromS[i] == INF) continue;

            int timeSum = distFromJ[i] + distFromS[i];
            // distFromJ[i]가 distFromS[i]보다 크면 무효 처리
            if (timeSum < minTimeSum ||
                    (timeSum == minTimeSum && distFromJ[i] < minDistFromJ)) {
                minTimeSum = timeSum;
                minDistFromJ = distFromJ[i];
                result = i;
            }
        }

        // 결과가 선택되었지만 distFromJ > distFromS인 경우
        if (result != -1 && distFromJ[result] > distFromS[result]) {
            return -1;
        }

        return result;
    }
}