import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < stones.length; i++) {
            // 범위를 벗어난 인덱스는 제거
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 현재 값보다 작거나 같은 값을 뒤에서 제거 (큰 값 유지)
            while (!deque.isEmpty() && stones[deque.peekLast()] <= stones[i]) {
                deque.pollLast();
            }

            deque.offerLast(i); // 현재 인덱스 삽입

            // 윈도우가 시작되는 지점부터 최소값 갱신
            if (i >= k - 1) {
                answer = Math.min(answer, stones[deque.peekFirst()]);
            }
        }

        return answer;
    }
}
