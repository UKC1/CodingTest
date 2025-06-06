import java.util.*;

class Solution {
    int n;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    final int INF = 1000000;

    public int solution(int[][] board) {
        n = board.length;
        int[][][] dp = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }
        dijkstra(board, dp);

        int min = INF;
        for (int i = 0; i < 4; i++) {
            min = Math.min(min, dp[n-1][n-1][i]);
        }
        return min;
    }

    void dijkstra(int[][] board, int[][][] dp) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[2]));
        for (int i = 0; i < 4; i++) {
            dp[0][0][i] = 0;
        }
        pq.offer(new int[] {0, 0, 0, -1}); // x, y, cost, dir

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int cost = cur[2];
            int dir = cur[3];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 0) {
                    int nextCost = 100;
                    if (dir != -1 && dir != i) nextCost += 500;

                    if (dp[nx][ny][i] > cost + nextCost) {
                        dp[nx][ny][i] = cost + nextCost;
                        pq.offer(new int[] {nx, ny, dp[nx][ny][i], i});
                    }
                }
            }
        }
    }
}
