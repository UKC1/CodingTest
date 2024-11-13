import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 학생 수 (노드 개수)
        int M = Integer.parseInt(st.nextToken()); // 키 비교 횟수 (간선 개수)
        
        // 그래프 초기화 및 진입 차수 배열
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        int[] inDegree = new int[N + 1];
        
        // 그래프 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            inDegree[to]++;
        }
        
        // 위상 정렬을 위한 큐와 결과 리스트
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        
        // 진입 차수가 0인 노드 큐에 추가
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // 위상 정렬 수행
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);
            
            for (int next : graph.get(curr)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int student : result) {
            sb.append(student).append(" ");
        }
        System.out.println(sb);
    }
}