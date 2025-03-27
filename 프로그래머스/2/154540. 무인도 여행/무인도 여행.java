import java.util.*;
class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    boolean[][] visited;
    int N;
    int M;
    int landSum;
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    visited[i][j] = true;
                    landSum = maps[i].charAt(j) - '0';
                    dfs(i, j, maps);
                    list.add(landSum);
                }
            }
        }
        int[] answer = new int[list.size()];
        if (answer.length == 0) {
            return new int[] {-1};
        }
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    
    void dfs(int x, int y, String[] maps) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && maps[nx].charAt(ny) != 'X') {        
                visited[nx][ny] = true;
                landSum += maps[nx].charAt(ny) - '0';
                dfs(nx, ny, maps);
            }
        }
    }
}