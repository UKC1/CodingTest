import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] maps;
    static List<int[]> activeVirus;
    static int totalBlanks;
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { -1, 0, 1, 0 };
    static int minTime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maps = new int[N][N];
        activeVirus = new ArrayList<>();
        totalBlanks = 0;
        minTime = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                if (maps[i][j] == 2) {
                    activeVirus.add(new int[]{i, j});
                } else if (maps[i][j] == 0) {
                    totalBlanks++;
                }
            }
        }
        // List 안에서 조합 M
        List<Integer> activeVirusIdx = new ArrayList<>();
        combination(0, 0, activeVirusIdx);
        System.out.print(minTime == Integer.MAX_VALUE ? -1 : minTime);
    }

    static void combination(int start, int idx, List<Integer> activeVirusIdx) {
        if (idx == M) {
            int currentTime = bfs(activeVirusIdx);
            if (currentTime != -1) {
                minTime = Math.min(minTime, currentTime);
            }
            return;
        }

        for (int i = start; i < activeVirus.size(); i++) {
            activeVirusIdx.add(i);
            combination(i + 1, idx + 1, activeVirusIdx);
            activeVirusIdx.remove(activeVirusIdx.size() - 1);
        }
    }

    static int bfs(List<Integer> activeVirusIdx) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        for (Integer idx : activeVirusIdx) {
            int[] arr = activeVirus.get(idx);
            queue.offer(arr);
            visited[arr[0]][arr[1]] = true;
        }

        int blanks = 0;
        int time = 0;
        while (!queue.isEmpty()) {
            if (blanks == totalBlanks) {
                return time;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && maps[nx][ny] != 1) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        if (maps[nx][ny] == 0) {
                            blanks++;
                        }
                    }
                }
            }
            time++;
        }

        return -1;

    }
}
