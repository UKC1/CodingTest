import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Solution {
    static int totalCnt;
    static int N, M, L;
    static int[][] maps;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}; // 상, 좌, 하, 우
    static int[] dy = {0, -1, 0, 1}; // 상, 좌, 하, 우
 
    // 파이프 타입별로 이동 가능한 방향을 정의한 배열 (상, 좌, 하, 우 순서)
    static int[][] pipeDirs = {
        {},                // 0: 없음
        {1, 1, 1, 1},      // 1: 상, 좌, 하, 우
        {1, 0, 1, 0},      // 2: 상, 하
        {0, 1, 0, 1},      // 3: 좌, 우
        {1, 0, 0, 1},      // 4: 상, 우
        {0, 0, 1, 1},      // 5: 하, 우
        {0, 1, 1, 0},      // 6: 좌, 하
        {1, 1, 0, 0}       // 7: 상, 좌
    };
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            maps = new int[N][M];
            visited = new boolean[N][M];
 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    maps[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            totalCnt = bfs(R, C);
 
            sb.append('#').append(test_case).append(' ').append(totalCnt).append('\n');
        }
        System.out.print(sb);
    }
 
    static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {startX, startY, 1});
        visited[startX][startY] = true;
        int count = 1;
 
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], time = cur[2];
 
            if (time == L) continue;
 
            int type = maps[x][y];
            for (int i = 0; i < 4; i++) {
                if (pipeDirs[type][i] == 0) continue; // 현재 파이프 방향이 이동할 수 없는 경우 스킵
 
                int nx = x + dx[i];
                int ny = y + dy[i];
 
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && maps[nx][ny] != 0) {
                    int nextType = maps[nx][ny];
                    if (pipeDirs[nextType][(i + 2) % 4] == 1) { // 다음 위치에서 현재 위치로 이어지는 방향이 맞는지 확인
                        visited[nx][ny] = true;
                        queue.offer(new int[] {nx, ny, time + 1});
                        count++;
                    }
                }
            }
        }
        return count;
    }
}