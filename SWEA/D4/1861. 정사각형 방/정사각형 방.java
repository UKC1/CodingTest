import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int maxMoves;
    static int minRoomNumber;
    static int N;
    static int cnt;
    static boolean[][] visited;
    static int[][] rooms;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            maxMoves = 0;
            minRoomNumber = Integer.MAX_VALUE;
            rooms = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    rooms[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visited = new boolean[N][N];
                    cnt = 1;
                    dfs(i, j);
                    if (cnt == maxMoves) {
                        minRoomNumber = Math.min(minRoomNumber, rooms[i][j]);
                    } else if (cnt > maxMoves) {
                        maxMoves = cnt;
                        minRoomNumber = rooms[i][j];
                    }
                }
            }

            sb.append('#').append(test_case).append(' ').append(minRoomNumber).append(' ').append(maxMoves).append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && rooms[nx][ny] == rooms[x][y] + 1) {
                visited[nx][ny] = true;
                cnt++;
                dfs(nx, ny);
            }
        }
    }
}