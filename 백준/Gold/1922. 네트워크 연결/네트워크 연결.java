import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Computer implements Comparable<Computer> {
        int u;
        int v;
        int cost;

        Computer(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Computer o) {
            return cost - o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        PriorityQueue<Computer> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new Computer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        UnionFind uf = new UnionFind(N + 1);
        int computerCnt = 0;
        int minCost = 0;
        while (!pq.isEmpty() && computerCnt < N) {
            Computer computer = pq.poll();
            if (uf.union(computer.u, computer.v)) {
                computerCnt++;
                minCost += computer.cost;
            }
        }

        System.out.println(minCost);



    }

    static class UnionFind {
        static int[] parent;
        static int[] rank;
        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        static int find(int x) {
            if (x != parent[x]) {
                x = find(parent[x]);
            }
            return x;
        }

        static boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX > rootY) {
                parent[rootX] = rootY;
                rank[rootY]++;
                return true;
            } else if (rootX < rootY) {
                parent[rootY] = rootX;
                rank[rootX]++;
                return true;
            }
            return false;
        }
    }
}