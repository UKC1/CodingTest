import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        visited = new boolean[2 * K + 1];
        if (N >= K) {
            System.out.println(N - K);
        } else {
            System.out.println(bfs(N, K));
        }
    }

    static int bfs(int N, int K) {
        int[] dx = {-1, 1, 2};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {N, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currNum = curr[0];
            int currCnt = curr[1];
            if (currNum == K) {
                return currCnt;
            }

            for (int i = 0; i < 3; i++) {
                int next = currNum + dx[i];
                if (dx[i] == 2) {
                    next = currNum * dx[i];
                }

                if (next >= 0 && next <= 2 * K && !visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[] {next, currCnt + 1});
                }
            }
        }
        return -1;
    }
}