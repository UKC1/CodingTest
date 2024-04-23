import java.util.*;

class Solution {
    static int[] dx = {0, 1, 0, -1};  // 상, 우, 하, 좌
    static int[] dy = {1, 0, -1, 0};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int maxCoord = 100;  // 좌표값의 최대 범위 (문제에서 주어진 범위의 2배)
        boolean[][] isBoundary = new boolean[maxCoord + 1][maxCoord + 1];
        boolean[][] visited = new boolean[maxCoord + 1][maxCoord + 1];

        // 모든 사각형에 대한 경계 설정
        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    if (x == x1 || x == x2 || y == y1 || y == y2) {
                        isBoundary[x][y] = true; // 외곽 경계 설정
                    }
                }
            }
        }

        // 겹치는 부분을 다시 내부로 설정
        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2 + 1;
            int y1 = rec[1] * 2 + 1;
            int x2 = rec[2] * 2 - 1;
            int y2 = rec[3] * 2 - 1;
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    isBoundary[x][y] = false; // 내부 경계 제거
                }
            }
        }

        // BFS로 최단 경로 탐색
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{characterX * 2, characterY * 2, 0});
        visited[characterX * 2][characterY * 2] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], cnt = current[2];

            if (x == itemX * 2 && y == itemY * 2) {
                return cnt / 2;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx <= maxCoord && ny <= maxCoord && !visited[nx][ny] && isBoundary[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, cnt + 1});
                }
            }
        }

        return -1;  // 경로를 찾을 수 없는 경우
    }
}
