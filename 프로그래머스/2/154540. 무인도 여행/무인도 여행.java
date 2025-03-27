import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    boolean[][] visited;
    int N, M;

    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && maps[i].charAt(j) != 'X') {
                    int sum = dfs(i, j, maps);
                    list.add(sum);
                }
            }
        }

        if (list.isEmpty()) return new int[] {-1};

        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        return answer;
    }

    int dfs(int x, int y, String[] maps) {
        visited[x][y] = true;
        int sum = maps[x].charAt(y) - '0';

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M &&
                !visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                sum += dfs(nx, ny, maps);
            }
        }

        return sum;
    }
}
