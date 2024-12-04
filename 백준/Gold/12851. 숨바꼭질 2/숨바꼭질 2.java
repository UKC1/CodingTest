import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int minNum;
    static int minCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        minNum = Integer.MAX_VALUE; // 최소 시간 초기화
        minCnt = 0;                 // 방법의 수 초기화

        bfs(N, K);

        System.out.println(minNum);
        System.out.println(minCnt);
    }

    private static void bfs(int start, int target) {
        int[] visited = new int[100001]; // 방문 시간 기록 (0~100000)
        for (int i = 0; i < visited.length; i++) {
            visited[i] = Integer.MAX_VALUE; // 초기값을 무한대로 설정
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start, 0}); // 초기 위치와 시간 추가
        visited[start] = 0; // 시작점은 0초

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int time = current[1];

            // 목표 위치에 도달한 경우
            if (position == target) {
                if (time < minNum) {
                    minNum = time; // 최소 시간 갱신
                    minCnt = 1;   // 방법 수 초기화
                } else if (time == minNum) {
                    minCnt++;     // 동일 시간 경로 추가
                }
                continue;
            }

            // 다음 위치 탐색
            int[] nextPositions = {position - 1, position + 1, position * 2};
            for (int next : nextPositions) {
                if (next >= 0 && next <= 100000) {
                    // 더 짧은 시간에 도달한 경우 또는 동일 시간에 다른 경로로 도달한 경우
                    if (visited[next] >= time + 1) {
                        queue.offer(new int[]{next, time + 1});
                        visited[next] = time + 1; // 방문 시간 갱신
                    }
                }
            }
        }
    }
}