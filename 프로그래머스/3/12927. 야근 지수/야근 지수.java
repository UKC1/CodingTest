import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < works.length; i++) {
            pq.offer(works[i]);
        }
        
        while (cnt < n) {
            int maxNum = pq.poll();
            if (maxNum > 0) maxNum--;
            pq.offer(maxNum);
            cnt++;
        }
    
        for (Integer num : pq) {
            answer += num * num;
        }
        
        return answer;
    }
}