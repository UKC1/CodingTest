import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<int[]>> cities;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 도시 수
        int M = Integer.parseInt(br.readLine()); // 버스 노선 수

        cities = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            cities.add(new ArrayList<>());
        }

        // 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            cities.get(start).add(new int[]{end, cost});
        }

        // 시작점과 끝점 입력
        st = new StringTokenizer(br.readLine());
        int startV = Integer.parseInt(st.nextToken());
        int endV = Integer.parseInt(st.nextToken());

        // 다익스트라 실행
        Result result = dijkstra(startV, endV, N);

        // 최소 비용 출력
        System.out.println(result.minCost);

        // 경로 길이 출력
        System.out.println(result.path.size());

        // 경로 출력
        for (int city : result.path) {
            System.out.print(city + " ");
        }
    }

    static class Result {
        int minCost;
        List<Integer> path;

        public Result(int minCost, List<Integer> path) {
            this.minCost = minCost;
            this.path = path;
        }
    }

    static Result dijkstra(int startV, int endV, int N) {
        int[] dist = new int[N + 1];
        int[] parent = new int[N + 1];
        Arrays.fill(dist, INF);
        Arrays.fill(parent, -1);
        dist[startV] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{startV, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int currentV = cur[0];
            int currentCost = cur[1];

            if (dist[currentV] < currentCost) continue;

            for (int[] next : cities.get(currentV)) {
                int nextV = next[0];
                int nextCost = currentCost + next[1];

                if (dist[nextV] > nextCost) {
                    dist[nextV] = nextCost;
                    parent[nextV] = currentV; // 부모 노드 기록
                    pq.offer(new int[]{nextV, nextCost});
                }
            }
        }

        // 경로 추적
        List<Integer> path = new ArrayList<>();
        for (int at = endV; at != -1; at = parent[at]) {
            path.add(at);
        }
        Collections.reverse(path); // 경로를 올바른 순서로 뒤집기

        return new Result(dist[endV], path);
    }
}