import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;
        int[] dx = {0, 0, -1, 1}; // L, R, D, U
        int[] dy = {-1, 1, 0, 0}; // L, R, D, U
        int[][] dirMap = {{'L', 0}, {'R', 1}, {'D', 2}, {'U', 3}};
        int answer = 0;

        for (char dir : dirs.toCharArray()) {
            int direction = -1;
            for (int i = 0; i < dirMap.length; i++) {
                if (dirMap[i][0] == dir) {
                    direction = dirMap[i][1];
                    break;
                }
            }

            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx >= -5 && nx <= 5 && ny >= -5 && ny <= 5) {
                String path1 = x + "," + y + "," + nx + "," + ny;
                String path2 = nx + "," + ny + "," + x + "," + y;

                if (!visited.contains(path1) && !visited.contains(path2)) {
                    visited.add(path1);
                    visited.add(path2);
                    answer++;
                }
                x = nx;
                y = ny;
            }
        }

        return answer;
    }
}
