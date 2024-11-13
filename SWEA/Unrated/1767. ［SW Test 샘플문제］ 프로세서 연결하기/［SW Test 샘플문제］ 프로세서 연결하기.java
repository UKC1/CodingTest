import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N;
    static int[][] maps;
    static List<int[]> cores;
    static int minLength, maxCoreCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            maps = new int[N][N];
            cores = new ArrayList<>();
            minLength = Integer.MAX_VALUE;
            maxCoreCount = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    maps[i][j] = Integer.parseInt(st.nextToken());
                    if (maps[i][j] == 1 && i > 0 && j > 0 && i < N - 1 && j < N - 1) {
                        cores.add(new int[]{i, j});
                    }
                }
            }

            dfs(0, 0, 0);
            sb.append("#").append(test_case).append(" ").append(minLength).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int depth, int coreCount, int lengthSum) {
        if (depth == cores.size()) {
            if (coreCount > maxCoreCount || (coreCount == maxCoreCount && lengthSum < minLength)) {
                maxCoreCount = coreCount;
                minLength = lengthSum;
            }
            return;
        }

        int[] core = cores.get(depth);
        int x = core[0];
        int y = core[1];

        // 4가지 방향으로 연결 시도
        for (int d = 0; d < 4; d++) {
            int len = 0;
            int nx = x;
            int ny = y;

            while (true) {
                nx += dx[d];
                ny += dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) break;
                if (maps[nx][ny] == 1) {
                    len = 0;
                    break;
                }
                len++;
            }

            if (len == 0) {
                dfs(depth + 1, coreCount, lengthSum);
            } else {
                setLine(x, y, d, true);
                dfs(depth + 1, coreCount + 1, lengthSum + len);
                setLine(x, y, d, false);
            }
        }
    }

    static void setLine(int x, int y, int d, boolean state) {
        int nx = x;
        int ny = y;
        while (true) {
            nx += dx[d];
            ny += dy[d];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) break;
            maps[nx][ny] = state ? 1 : 0;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
}