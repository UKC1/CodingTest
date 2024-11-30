import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        // 정렬을 해서 접근하자
        int answer = 0;
        Arrays.sort(B);
        Deque<Integer> dq = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < A.length; i++) {
            pq.offer(A[i]);
            dq.push(B[i]);
        }
        while(!pq.isEmpty()) {
            int numA = pq.poll();
            if (numA < dq.peekFirst()) {
                answer++;
                dq.pollFirst();
            } else {
                dq.pollLast();
            }
        }
        return answer;
    }
}