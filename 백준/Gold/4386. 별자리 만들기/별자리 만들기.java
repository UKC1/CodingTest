import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Star {
        int u;
        int v;
        double dist;

        Star(int u, int v, double dist) {
            this.u = u;
            this.v = v;
            this.dist = dist;
        }

        public double getDist() {
            return dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        double[][] maps = new double[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            maps[i][0] = Double.parseDouble(st.nextToken());
            maps[i][1] = Double.parseDouble(st.nextToken());
        }

        List<Star> stars = new ArrayList<Star>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double diffX = maps[i][0] - maps[j][0];
                double diffY = maps[i][1] - maps[j][1];
                double distance = Math.sqrt(diffX * diffX + diffY * diffY);
                stars.add(new Star(i, j, distance));
            }
        }

        stars.sort(Comparator.comparingDouble(Star::getDist));
        Union un = new Union(N + 1);
        int starCnt = 0;
        double minCost = 0;
        for (Star s : stars) {
            if (un.union(s.u, s.v)) {
                minCost += s.dist;
                starCnt++;

                if (starCnt == N - 1) break;
            }
        }
        System.out.printf("%.3f", minCost);

    }

    static class Union {
        int[] parent;

        Union(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (x != parent[x]) {
                x = find(parent[x]);
            }
            return x;
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