import java.util.*;

class Solution {
    static int[] dx = {1, 0, 0, -1};  // 상, 우, 하, 좌
    static int[] dy = {0, 1, -1, 0};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        boolean[][] isBoundary = new boolean[102][102];  // 경계 확인용
        boolean[][] visited = new boolean[102][102];    // 방문 처리

        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;

            // 사각형 경계 그리기
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    if (x == x1 || x == x2 || y == y1 || y == y2) {
                        isBoundary[x][y] = true; // 외곽 경계 설정
                    }
                }
            }
        }

        // 겹치는 부분을 내부로 처리
        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2 + 1;
            int y1 = rec[1] * 2 + 1;
            int x2 = rec[2] * 2 - 1;
            int y2 = rec[3] * 2 - 1;

            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    isBoundary[x][y] = false;
                }
            }
        }

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

                if (nx >= 0 && ny >= 0 && nx < 102 && ny < 102 && !visited[nx][ny] && isBoundary[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, cnt + 1});
                }
            }
        }

        return -1;
    }
}
