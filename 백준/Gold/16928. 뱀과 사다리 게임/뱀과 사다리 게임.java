import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static Map<Integer, Integer> jump;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 사다리 개수
        M = Integer.parseInt(st.nextToken()); // 뱀 개수
        jump = new HashMap<>();

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            jump.put(start, end);
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        boolean[] visited = new boolean[101];
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curr = cur[0];
            int cnt = cur[1];

            if (curr == 100) {
                return cnt;
            }

            // 주사위 굴리기
            for (int dice = 1; dice <= 6; dice++) {
                int next = curr + dice;
                if (next > 100) continue; // 100을 넘어가면 무시
                if (visited[next]) continue; // 이미 방문한 곳이면 무시
                
                // 뱀이나 사다리가 있는 경우 이동
                if (jump.containsKey(next)) {
                    next = jump.get(next);
                }

                // 방문 체크 & 큐에 추가
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, cnt + 1});
                }
            }
        }
        return 0;
    }
}
