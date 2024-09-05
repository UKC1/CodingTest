import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static List<Edge> edges = new ArrayList<>();
    static int islandCount = 0;

    static class Edge implements Comparable<Edge> {
        int u, v, dist;

        Edge(int u, int v, int dist) {
            this.u = u;
            this.v = v;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 섬 구분 및 번호 매기기
        int islandId = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, islandId++);
                }
            }
        }
        islandCount = islandId - 1;

        // 2. 섬 간의 가능한 다리 구하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    buildBridge(i, j, map[i][j]);
                }
            }
        }

        // 3. MST (크루스칼 알고리즘)
        UnionFind uf = new UnionFind(islandCount + 1);
        Collections.sort(edges);
        int minCost = 0;
        int edgeCount = 0;

        for (Edge edge : edges) {
            if (uf.union(edge.u, edge.v)) {
                minCost += edge.dist;
                edgeCount++;
            }
            if (edgeCount == islandCount - 1) break;
        }

        if (edgeCount == islandCount - 1) {
            System.out.println(minCost);
        } else {
            System.out.println(-1); // 모든 섬을 연결할 수 없는 경우
        }
    }

    // 섬 구분을 위한 DFS
    static void dfs(int x, int y, int islandId) {
        visited[x][y] = true;
        map[x][y] = islandId;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && map[nx][ny] == 1) {
                dfs(nx, ny, islandId);
            }
        }
    }

    // 다리를 건설할 수 있는지 확인하고, 가능한 다리를 추가
    static void buildBridge(int x, int y, int islandId) {
        for (int dir = 0; dir < 4; dir++) {
            int nx = x;
            int ny = y;
            int length = 0;

            while (true) {
                nx += dx[dir];
                ny += dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == islandId) {
                    break; // 바다 밖으로 나가거나 같은 섬에 닿는 경우
                }

                if (map[nx][ny] == 0) {
                    length++;
                } else {
                    if (length >= 2) { // 다리 길이는 2 이상이어야 함
                        edges.add(new Edge(islandId, map[nx][ny], length));
                    }
                    break;
                }
            }
        }
    }
}