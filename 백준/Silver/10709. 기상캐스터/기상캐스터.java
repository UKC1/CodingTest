import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] maps = new int[H][W];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < H; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                if (chars[j] == '.') {
                    maps[i][j] = -1;
                } else {
                    maps[i][j] = 0;
                    queue.offer(new int[]{i, j, 1});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];

            int nx = x;
            int ny = y + 1;
            if (ny >= W) continue;
            if (maps[nx][ny] == -1) {
                maps[nx][ny] = cnt;
                queue.offer(new int[]{nx, ny, cnt + 1});
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                sb.append(maps[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
