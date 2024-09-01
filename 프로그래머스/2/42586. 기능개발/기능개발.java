import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 순서가 보장이 되어야 함!
        // 앞에 있는 애가 나가야 다음에!
        Queue<Integer> queue = new ArrayDeque<>();
        int totalCnt = 0;
        int start = 0;
        
        while (totalCnt < progresses.length) {
            for (int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }    
            // 맨 처음이 배포 가능하면?
            if (progresses[start] >= 100) {
                // 배포 가능한 애들 다 찾아!
                int cnt = 0;
                while(start < progresses.length && progresses[start] >= 100) {
                    cnt++;
                    start++;
                }
                totalCnt += cnt;
                queue.offer(cnt);
            }
        }
        int[] answer = new int[queue.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = queue.poll();
        }
        
        return answer;
    }
}