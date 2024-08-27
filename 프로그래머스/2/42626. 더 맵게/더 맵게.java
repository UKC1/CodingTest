import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int scov : scoville) {
            pq.offer(scov);
        }
        
        int cnt = 0;
        while(pq.size() > 1 && pq.peek() < K) {
            int newScov = pq.poll() + pq.poll() * 2;
            pq.offer(newScov);
            cnt++;
        }
        
        if (pq.peek() < K) {
            return -1;
        }
        
        return cnt;
    }
}