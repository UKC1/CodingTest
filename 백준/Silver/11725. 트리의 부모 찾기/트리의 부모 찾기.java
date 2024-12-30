import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> graph; // 인접 리스트로 그래프 표현
    static int[] parent; // 부모 노드를 저장할 배열
    static int N; // 노드 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력: 노드 개수
        N = Integer.parseInt(br.readLine());

        // 그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        // 부모 노드 배열 초기화
        parent = new int[N + 1];

        // DFS로 부모 찾기 (루트 노드는 1)
        dfs(1, 0);

        // 결과 출력: 2번 노드부터 N번 노드까지 부모 출력
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    // DFS를 사용해 부모 노드를 찾는 함수
    static void dfs(int current, int parentNode) {
        parent[current] = parentNode; // 현재 노드의 부모를 설정

        // 현재 노드와 연결된 모든 노드 탐색
        for (int next : graph.get(current)) {
            if (next != parentNode) { // 부모 노드로 다시 돌아가지 않도록 방지
                dfs(next, current);
            }
        }
    }
}