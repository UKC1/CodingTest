import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static List<List<Integer>> graph;
    static int[] order;
    static int cnt = 1; // 방문 순서 카운트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        order = new int[N + 1]; // 방문 순서를 저장하는 배열

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 방문할 노드를 오름차순으로 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        boolean[] visited = new boolean[N + 1];
        dfs(R, visited);

        // 방문 순서 출력
        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int vertex, boolean[] visited) {
        visited[vertex] = true;
        order[vertex] = cnt++; // 방문 순서 저장

        for (int next : graph.get(vertex)) {
            if (!visited[next]) {
                dfs(next, visited);
            }
        }
    }
}
