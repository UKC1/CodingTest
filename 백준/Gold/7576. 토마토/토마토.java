import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int minDays;
    static boolean isCompleted;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<int[]> queue = new ArrayDeque<>();
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] tomatoes = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if (tomatoes[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        minDays = 0;
        boolean[][] visited = new boolean[N][M];
        while (!queue.isEmpty()) {
            boolean isChanged = false;
            int size = queue.size();
            for (int cnt = 0; cnt < size; cnt++) {
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];
                visited[x][y] = true;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && tomatoes[nx][ny] == 0) {
                        tomatoes[nx][ny] = 1;
                        queue.offer(new int[]{nx, ny});
                        isChanged = true;
                    }
                }
            }
            if (isChanged) {
                minDays++;
            }
        }

        isCompleted = check(tomatoes);
        System.out.println(isCompleted ? minDays : -1);
    }

    static boolean check(int[][] tomatoes) {
        for (int i = 0; i < tomatoes.length; i++) {
            for (int j = 0; j < tomatoes[i].length; j++) {
                if (tomatoes[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}