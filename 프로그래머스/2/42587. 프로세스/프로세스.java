import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            deque.offer(priorities[i]);
        }

        while (!deque.isEmpty()) {
            int process = deque.poll();
            boolean isFirst = true;
            for (Integer i : deque) {
                if (process < i) {
                    isFirst = false;
                    break;
                }
            }

            if (isFirst) {
                if (location == 0) {
                    return priorities.length - deque.size();
                }
                location--;
            } else {
                deque.addLast(process);
                if (location == 0) {
                    location = deque.size() - 1;
                } else {
                    location--;
                }
            }
            
        }

        return answer;
    }
}