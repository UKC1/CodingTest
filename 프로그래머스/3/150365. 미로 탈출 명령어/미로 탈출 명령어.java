import java.util.*;

class Solution {
    private static final int[] dx = {1, -1, 0, 0}; // 아래, 위, 왼쪽, 오른쪽
    private static final int[] dy = {0, 0, -1, 1}; // 아래, 위, 왼쪽, 오른쪽
    private static final char[] directions = {'d', 'u', 'l', 'r'}; // 방향 문자

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparing(state -> state.path));
        pq.add(new State(x, y, 0, ""));
        boolean[][][] visited = new boolean[n + 1][m + 1][k + 1];
        visited[x][y][0] = true;

        while (!pq.isEmpty()) {
            State current = pq.poll();

            if (current.dist == k) {
                if (current.x == r && current.y == c) {
                    return current.path;
                }
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx > 0 && nx <= n && ny > 0 && ny <= m && current.dist + 1 <= k) {
                    if (!visited[nx][ny][current.dist + 1]) {
                        visited[nx][ny][current.dist + 1] = true;
                        pq.add(new State(nx, ny, current.dist + 1, current.path + directions[i]));
                    }
                }
            }
        }

        return "impossible";
    }

    private static class State {
        int x, y, dist;
        String path;

        State(int x, int y, int dist, String path) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.path = path;
        }
    }
}
