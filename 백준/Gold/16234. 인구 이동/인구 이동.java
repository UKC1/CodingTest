import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int L;
    static int R;
    static int[][] worlds;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        worlds = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                worlds[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 인구 이동 없을 때 까지 지속
        // 1. 국경선을 공유하는 두 나라의 인구 차이가 L 이상 R 이하
        // 2. 하루 동안 연다 인접한 칸만을 이용해 이동(열려 있으면)
        // 3. 연합을 이루고 있는 각 칸의 인구수는 연합의 인구수 / 연합을 이루고 있는 칸의 개수
        // 4. 연합을 해체하고, 모든 국경선을 닫는다. 소수점은 버린다.

        // 국경선을 공유하는 영역찾기
        int day = 0;
        while(true) {
            boolean flag = false;
            boolean[][] visited  = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        List<int[]> points = new ArrayList<>();
                        dfs(i, j, visited, points);
                        if (points.size() > 1) {
                            flag = true;
                            resetPerson(points);
                        }
                    }
                }
            }
            if (!flag) {
                break;
            }
            day++;
        }
        System.out.print(day);
    }
    static void resetPerson(List<int[]> points) {
        int sum = 0;
        for (int[] p : points) {
            sum += worlds[p[0]][p[1]];
        }

        sum /= points.size();
        for (int[] p : points) {
            worlds[p[0]][p[1]] = sum;
        }
    }
    static void dfs(int x, int y, boolean[][] visited, List<int[]> points) {
        visited[x][y] = true;
        points.add(new int[]{x, y});
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            int diff = Math.abs(worlds[nx][ny] - worlds[x][y]);
            if (!visited[nx][ny] && diff >= L && diff <= R) {
                dfs(nx, ny, visited, points);
            }
        }
    }
}