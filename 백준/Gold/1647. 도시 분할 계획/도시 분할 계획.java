import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class City {
        int u;
        int v;
        int retainCost;

        City(int u, int v, int retainCost) {
            this.u = u;
            this.v = v;
            this.retainCost = retainCost;
        }

        public int getRetainCost() {
            return retainCost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<City> pq = new PriorityQueue<>(Comparator.comparingInt(City::getRetainCost));
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new City(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        UnionFind un = new UnionFind(N + 1);
        int cityCnt = 0;
        int minCost = 0;
        int maxEdgeCost = 0;  // MST에서 가장 큰 가중치 간선을 추적

        while (!pq.isEmpty() && cityCnt < N - 1) {  // N - 1개의 간선까지만 선택
            City c = pq.poll();
            if (un.union(c.u, c.v)) {
                cityCnt++;
                minCost += c.retainCost;
                maxEdgeCost = Math.max(maxEdgeCost, c.retainCost);  // 가장 큰 가중치 간선 추적
            }
        }

        // MST에서 가장 큰 가중치 간선을 제외한 최소 비용 출력
        System.out.print(minCost - maxEdgeCost);
    }

    static class UnionFind {
        int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
                return true;
            }
            return false;
        }
    }
}