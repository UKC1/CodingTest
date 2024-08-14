import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        int[][] map = new int[M][N];
        boolean[][] visited = new boolean[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = M - Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int endX = M - Integer.parseInt(st.nextToken());

            int minX = Math.min(startX, endX);
            int minY = Math.min(startY, endY);
            int maxX = Math.max(startX, endX);
            int maxY = Math.max(startY, endY);
            for (int x = minX; x < maxX; x++) {
                for (int y = minY; y < maxY; y++) {
                    map[x][y] = 1;
                }
            }
        }


        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                if (map[x][y] == 0 && !visited[x][y]) {
                    list.add(dfs(map, visited, x, y, 0));
                }
            }
        }
        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for (Integer num : list) {
            sb.append(num).append(" ");
        }
        System.out.print(sb);

    }

    static int dfs(int[][] map, boolean[][] visited, int x, int y, int cnt) {
        int m = map.length;
        int n = map[0].length;
        visited[x][y] = true;
        cnt++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && map[nx][ny] == 0) {
                cnt = dfs(map, visited, nx, ny, cnt);
            }
        }
        return cnt;
    }
}