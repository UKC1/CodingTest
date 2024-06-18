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
                String path1 = x + "," + y + "," + nx + "," + ny;
                String path2 = nx + "," + ny + "," + x + "," + y;

                if (visited.add(path1)) {  // if path1 is newly added, path2 will be implicitly added
                    visited.add(path2);
                }
                x = nx;
                y = ny;
            }
        }
        return visited.size() / 2;  // since each path is stored twice
    }
}
