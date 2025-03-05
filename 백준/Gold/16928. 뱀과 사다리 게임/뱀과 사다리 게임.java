import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static Map<Integer, Integer> jump;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        jump = new HashMap<>();
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            jump.put(start, end);
        }

        int cnt = bfs();
        System.out.print(cnt);
    }

    static int bfs() {
        int start = 1;
        int end = 100;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        boolean[] visited = new boolean[101];
        visited[start] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curr = cur[0];
            int cnt = cur[1];
            if (curr == end) {
                return cnt;
            }
            // 주사위를 굴려서 이동
            // 이동한 좌표에 사다리나 뱀이 있으면 점프해야 됨
            for (int dice = 1; dice <= 6; dice++) {
                int next = curr + dice;
                if (next <= end && !visited[next]) {
                    visited[next] = true;
                    if (jump.containsKey(next)) {
                        queue.offer(new int[]{jump.get(next), cnt + 1});
                    } else {
                        queue.offer(new int[]{next, cnt + 1});
                    }
                }
            }
        }
        return 0;

    }
}


