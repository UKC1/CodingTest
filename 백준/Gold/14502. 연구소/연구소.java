import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int [][] maps;
    static boolean[][] visited;
    static List<int[]> blanks;
    static List<int[]> virus;
    static int wallsCnt;
    static int maxSafeZone;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maps = new int[N][M];
        blanks = new ArrayList<>();
        virus = new ArrayList<>();
        maxSafeZone = 0;
        wallsCnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                if (maps[i][j] == 0) {
                    blanks.add(new int[]{i, j});
                } else if (maps[i][j] == 2) {
                    virus.add(new int[]{i, j});
                } else if (maps[i][j] == 1) {
                    wallsCnt++;
                }
            }
        }

        // 벽은 3개 세울 수 있음
        combination(new int[3], 0, 0);
        // 0 : 빈 칸
        // 1 : 벽
        // 2 : 바이러스
        // 바이러스는 상하좌우로 퍼짐
        // 안전 영역 크기의 최댓값을 구하라
        System.out.print(maxSafeZone);


    }
    static void combination(int[] arr, int index, int start) {
        if (index == 3) {
            // 벽 3개 세우자
            for (Integer idx : arr) {
                int x = blanks.get(idx)[0];
                int y = blanks.get(idx)[1];
                maps[x][y] = 1;
            }
            // 바이러스 퍼뜨리기 시작, 바이러스 개수 반환
            int virusCnt = bfs();

            // 안전지대 카운트
            int safeCnt = N * M - virusCnt - wallsCnt - 3;


            if (safeCnt > maxSafeZone) maxSafeZone = safeCnt;


            // 벽 3개 원래대로
            for (Integer idx : arr) {
                int x = blanks.get(idx)[0];
                int y = blanks.get(idx)[1];
                maps[x][y] = 0;
            }
            return;
        }
        for (int i = start; i < blanks.size(); i++) {
            arr[index] = i;
            combination(arr, index + 1, i + 1);
        }

    }

    static int bfs() {
        int virusCnt = virus.size();
        visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        // 초기화
        for (int i = 0; i < virus.size(); i++) {
            int x = virus.get(i)[0];
            int y = virus.get(i)[1];
            queue.offer(new int[]{x, y});
            visited[x][y] = true;
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && maps[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    virusCnt++;
                }
            }
        }
        return virusCnt;
    }
}