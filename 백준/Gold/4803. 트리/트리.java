import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int vertexCnt;
    static int groupCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = 1;
        while(true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            // 사이클 체크

            int treeCnt = countTree(graph);
            if (treeCnt > 1) {
                sb.append("Case ").append(T).append(": A forest of ").append(treeCnt).append( " trees.").append('\n');
            } else if (treeCnt == 1) {
                sb.append("Case ").append(T).append(": There is one tree.").append('\n');
            } else {
                sb.append("Case ").append(T).append(": No trees.").append('\n');
            }
            T++;
        }
        System.out.print(sb);
    }
    static int countTree(List<List<Integer>> graph) {
        int cnt = 0;
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                vertexCnt = 0;
                groupCnt = 0;
                dfs(i, graph, visited);
                if (vertexCnt > groupCnt / 2) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void dfs(int u, List<List<Integer>> graph, boolean[] visited) {
        visited[u] = true;
        groupCnt += graph.get(u).size();
        vertexCnt++;
        for (int v : graph.get(u)) {
            if (!visited[v]) {
                dfs(v, graph, visited);
            }
        }
    }
}

