import java.util.*;

class Solution {
    int minCnt = Integer.MAX_VALUE;
    public int solution(int x, int y, int n) {
        int answer = 0;
        bfs(x, y, n);
        return minCnt == Integer.MAX_VALUE ? -1 : minCnt;
    }
    
    public void bfs(int current, int target, int n) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {current, 0});
        Set<Integer> set = new HashSet<>();
        set.add(current);
        
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int currentNum = arr[0];
            int count = arr[1];
            
            if (currentNum == target) {
                minCnt = count;
                return;
            }
            
            if (!set.contains(currentNum + n) && currentNum + n <= target) {
                set.add(currentNum + n);
                queue.offer(new int[] {currentNum + n, count + 1});
            }
            
            
            if (!set.contains(currentNum * 2) && currentNum * 2 <= target) {
                set.add(currentNum * 2);
                queue.offer(new int[] {currentNum * 2, count + 1});
            }
            
            
            if (!set.contains(currentNum * 3) && currentNum * 3 <= target) {
                set.add(currentNum * 3);
                queue.offer(new int[] {currentNum * 3, count + 1});
            }
        }
    
    }
}