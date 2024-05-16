import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean[] visited = new boolean[dungeons.length];
        List<Integer> list = new ArrayList();
        permutation(dungeons, visited, list, k, 0);
        Collections.sort(list);
        
        return list.get(list.size() - 1);
    }
    
    public void permutation(int[][] dungeons, boolean[] visited, List<Integer> list, int k, int cnt) {
        if (cnt == visited.length) {
            list.add(cnt);
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (k >= dungeons[i][0] && !visited[i]) {
                visited[i] = true;
                permutation(dungeons, visited, list, k - dungeons[i][1], cnt + 1);
                visited[i] = false;
            }
        }
        
        list.add(cnt);
    }
}