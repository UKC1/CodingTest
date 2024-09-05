import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Planet {
        int id;  // 행성의 번호
        int x, y, z;

        Planet(int id, int x, int y, int z) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Edge implements Comparable<Edge> {
        int u, v, cost;

        Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;  // 비용이 적은 순으로 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Planet> planets = new ArrayList<>();

        // 행성의 정보를 입력받음
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets.add(new Planet(i, x, y, z));  // 행성의 ID와 좌표 저장
        }

        // 간선을 저장할 리스트
        List<Edge> edges = new ArrayList<>();

        // x축 기준으로 정렬 후 인접한 행성 간의 간선을 추가
        planets.sort(Comparator.comparingInt(p -> p.x));
        for (int i = 0; i < N - 1; i++) {
            int cost = Math.abs(planets.get(i).x - planets.get(i + 1).x);
            edges.add(new Edge(planets.get(i).id, planets.get(i + 1).id, cost));
        }

        // y축 기준으로 정렬 후 인접한 행성 간의 간선을 추가
        planets.sort(Comparator.comparingInt(p -> p.y));
        for (int i = 0; i < N - 1; i++) {
            int cost = Math.abs(planets.get(i).y - planets.get(i + 1).y);
            edges.add(new Edge(planets.get(i).id, planets.get(i + 1).id, cost));
        }

        // z축 기준으로 정렬 후 인접한 행성 간의 간선을 추가
        planets.sort(Comparator.comparingInt(p -> p.z));
        for (int i = 0; i < N - 1; i++) {
            int cost = Math.abs(planets.get(i).z - planets.get(i + 1).z);
            edges.add(new Edge(planets.get(i).id, planets.get(i + 1).id, cost));
        }

        // Kruskal 알고리즘을 위해 간선들을 우선순위 큐에 넣음
        PriorityQueue<Edge> pq = new PriorityQueue<>(edges);

        // 유니온 파인드 (Union-Find) 초기화
        UnionFind uf = new UnionFind(N);

        int minCost = 0;
        int edgeCnt = 0;

        // Kruskal 알고리즘 수행
        while (!pq.isEmpty() && edgeCnt < N - 1) {
            Edge edge = pq.poll();
            if (uf.union(edge.u, edge.v)) {
                minCost += edge.cost;
                edgeCnt++;
            }
        }

        // 최소 비용 출력
        System.out.print(minCost);
    }

    // 유니온 파인드 클래스
    static class UnionFind {
        int[] parent;

        UnionFind(int N) {
            parent = new int[N];
            for (int i = 0; i < N; i++) {
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