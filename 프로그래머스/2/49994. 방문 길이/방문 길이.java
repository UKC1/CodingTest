import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;
        
        Map<Character, int[]> directions = new HashMap<>();
        directions.put('L', new int[]{-1, 0});
        directions.put('R', new int[]{1, 0});
        directions.put('D', new int[]{0, -1});
        directions.put('U', new int[]{0, 1});
        
        for (char dir : dirs.toCharArray()) {
            int[] move = directions.get(dir);
            int nx = x + move[0];
            int ny = y + move[1];

            if (nx >= -5 && nx <= 5 && ny >= -5 && ny <= 5) {
                StringBuilder path1 = new StringBuilder();
                path1.append(x).append(",").append(y).append(",").append(nx).append(",").append(ny);
                
                StringBuilder path2 = new StringBuilder();
                path2.append(nx).append(",").append(ny).append(",").append(x).append(",").append(y);

                if (visited.add(path1.toString())) {
                    visited.add(path2.toString());
                }
                
                x = nx;
                y = ny;
            }
        }
        return visited.size() / 2;
    }
}
