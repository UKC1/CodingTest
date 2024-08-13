import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Integer> list =  new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (!visited[x][y] && board[x][y] == '1') {
                    int cnt = dfs(board, visited, x, y, 0);
                    list.add(cnt);

                }
            }
        }

        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.print(sb);
    }

    static int dfs(char[][] board, boolean[][] visited, int x, int y, int cnt) {
        int n = board.length;
        visited[x][y] = true;
        cnt++;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && board[nx][ny] == '1') {
                cnt = dfs(board, visited, nx, ny, cnt);
            }
        }
        return cnt;
    }
}