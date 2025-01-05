import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge {
        int u, v, dist;
        public Edge(int u, int v, int dist) {
            this.u = u;
            this.v = v;
            this.dist = dist;
        }

        public int getDist() {
            return dist;
        }
    }

    static class UnionFind {
        int[] parent;
        UnionFind(int n) {
            parent = new int[n + 1];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        int findParent(int x) {
            if (parent[x] != x) {
                parent[x] = findParent(parent[x]);
            }
            return parent[x];
        }

        boolean union(int x, int y) {
            int rootX = findParent(x);
            int rootY = findParent(y);
            if (rootX == rootY) {
                return false;
            }
            parent[rootX] = rootY;
            return true;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringTokenizer st;
        while (!(str = br.readLine()).equals("0 0")) {
            int M = Integer.parseInt(str.split(" ")[0]);
            int N = Integer.parseInt(str.split(" ")[1]);
            PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getDist));
            int totalCost = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                pq.offer(new Edge(x, y, z));
                totalCost += z;
            }
            UnionFind uf = new UnionFind(M);
            int minCost = 0;
            int cnt = 0;
            while (!pq.isEmpty()) {
                Edge e = pq.poll();
                int u = e.u;
                int v = e.v;
                int dist = e.dist;
                if (uf.union(u, v)) {
                    minCost += dist;
                    cnt++;
                    if (cnt == M - 1) break;
                }
            }
            System.out.println(totalCost - minCost);
        }
    }
}