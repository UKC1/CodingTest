import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Solution {
    static int V;
    static int E;
    static List<Integer>[] adjList;
    static boolean[] visited;
    static Stack<Integer> stack;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= 10; test_case++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
 
            // 인접 리스트 초기화
            adjList = new ArrayList[V + 1];
            for (int i = 1; i <= V; i++) {
                adjList[i] = new ArrayList<>();
            }
 
            // 방문 배열 및 스택 초기화
            visited = new boolean[V + 1];
            stack = new Stack<>();
 
            // 간선 정보 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                adjList[A].add(B); // A -> B
            }
 
            // DFS로 모든 정점 탐색
            for (int i = 1; i <= V; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }
 
            // 스택에 저장된 결과를 출력
            sb.append("#").append(test_case);
            while (!stack.isEmpty()) {
                sb.append(" ").append(stack.pop());
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
 
    // DFS 탐색
    static void dfs(int node) {
        visited[node] = true;
 
        // 인접한 노드 방문
        for (int next : adjList[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
 
        // 모든 인접한 노드를 방문한 후에 스택에 추가
        stack.push(node);
    }
}