import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            List<Integer> list = new ArrayList<Integer>();
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] arr = new int[M][N];
            boolean[][] visited = new boolean[M][N];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }

            for (int x = 0; x < arr.length; x++) {
                for (int y = 0; y < arr[i].length; y++) {
                    if (arr[x][y] == 1 && !visited[x][y]) {
                        int cnt = dfs(arr, visited, x, y);
                        list.add(cnt);
                    }
                }
            }
            System.out.println(list.size());
        }
    }

    static int dfs(int[][] arr, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        int cnt = 1;
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 1 && !visited[nx][ny]) {
                cnt = dfs(arr, visited, nx, ny);
            }
        }
        return cnt;
    }
}