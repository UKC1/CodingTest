import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Computer {
        int u;
        int v;
        int cost;

        Computer(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        public int getCost() {
            return cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Computer> computers = new ArrayList<Computer>();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            computers.add(new Computer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        computers.sort(Comparator.comparingInt(Computer::getCost));
        UnionFind uf = new UnionFind(N + 1);
        int computerCnt = 0;
        int minCost = 0;
        for (Computer computer : computers) {
            if(uf.union(computer.u, computer.v)) {
                computerCnt++;
                minCost += computer.getCost();

                if (computerCnt == N - 1) break;
            }
        }

        System.out.println(minCost);



    }

    static class UnionFind {
        static int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
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

            if (rootX != rootY) {
                parent[rootX] = rootY;
                return true;
            }
            return false;
        }
    }
}