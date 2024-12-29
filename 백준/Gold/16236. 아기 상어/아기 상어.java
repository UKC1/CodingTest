import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] maps;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        maps = new int[N][N];
        int startX = -1, startY = -1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                // 아기상어 위치
                if (maps[i][j] == 9) {
                    maps[i][j] = 0;
                    startX = i;
                    startY = j;
                }
            }
        }
        // 아기상어 위치 초기 크기 2
        // 규칙
        // 1. 크기
        // 자신 보다 작은 물고기만 먹을 수 있음
        // 큰 물고기는 접근 x 같은 물고기는 지나가기 o
        // 2. 우선순위
        // 2.1 거리 상하좌우로 움직이되 최소값으로 움직임
        // 2.2 거리가 같으면 위쪽, 왼쪽이 우선
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 2, 0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int size = cur[2];
            int eatFishes = cur[3];
            int time = cur[4];
            if (size == eatFishes) {
                size++;
                eatFishes = 0;
            }
            // 작은 물고기들 찾기
            int[] smallFish = searchFish(x, y, size);
            if (smallFish == null) {
                System.out.println(time);
                break;
            }

            int nx = smallFish[0];
            int ny = smallFish[1];
            int distTime = smallFish[2];
            maps[nx][ny] = 0;
            queue.offer(new int[] {nx, ny, size, eatFishes + 1, time + distTime});
        }
    }
    static int[] searchFish(int startX, int startY, int size) {
        int minX = -1;
        int minY = -1;
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (maps[i][j] != 0 && maps[i][j] < size) {
                    // 작은 물고기들의 좌표, 크기, 거리
                    int dist = bfs(startX, startY, i, j, size);
                    // 도달할 수 있으면 리스트에 담기 크기는 필요 없음
                    if (dist != -1) {
                        if (dist < minDist) {
                            minDist = dist;
                            minX = i;
                            minY = j;
                        }
                    }
                }
            }
        }
        if (minX == -1 || minY == -1 || minDist == Integer.MAX_VALUE) {
            return null;
        }
        return new int[] {minX, minY, minDist};
    }

    static int bfs(int startX, int startY, int endX, int endY, int size) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            if (x == endX && y == endY) {
                return dist;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && maps[nx][ny] <= size) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }
        return -1;
    }
}