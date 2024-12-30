import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static int[] parent; // 부모 노드를 저장할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력: 노드 개수
        int N = Integer.parseInt(br.readLine());

        // 그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < N - 1; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        // 부모 노드 저장 배열 초기화
        parent = new int[N + 1];

        // DFS 비재귀 방식으로 부모 찾기
        findParents(N);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);
    }

    // DFS 비재귀 방식
    static void findParents(int N) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1); // 루트 노드부터 시작
        parent[1] = -1; // 루트 노드는 부모가 없음 (-1로 표시)

        while (!stack.isEmpty()) {
            int current = stack.pop();

            // 현재 노드와 연결된 모든 노드 탐색
            for (int next : graph.get(current)) {
                if (parent[next] == 0) { // 아직 방문하지 않은 노드
                    parent[next] = current; // 부모 설정
                    stack.push(next); // 다음 노드로 이동
                }
            }
        }
    }
}