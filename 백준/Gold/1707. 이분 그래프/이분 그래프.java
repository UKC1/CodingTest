import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static int[] color; // 1 또는 -1로 색을 칠함
    static boolean isBipartite;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // 테스트 케이스 수

        for (int test_case = 0; test_case < K; test_case++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            // 그래프 초기화
            graph = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }

            // 간선 입력
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            // 색깔 배열 초기화
            color = new int[V + 1];
            isBipartite = true;

            // 모든 노드에 대해 DFS 수행
            for (int v = 1; v <= V; v++) {
                if (color[v] == 0) { // 방문하지 않은 경우
                    dfs(v, 1);
                }
            }

            // 결과 출력
            System.out.println(isBipartite ? "YES" : "NO");
        }
    }

    static void dfs(int v, int c) {
        color[v] = c; // 현재 노드에 색 칠하기
        for (int next : graph.get(v)) {
            if (color[next] == 0) { // 아직 방문하지 않은 경우
                dfs(next, -c); // 반대 색으로 칠함
            } else if (color[next] == color[v]) { // 이미 방문했는데 같은 색이면
                isBipartite = false;
            }
        }
    }
}