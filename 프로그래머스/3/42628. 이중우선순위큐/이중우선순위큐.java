import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for (String operate : operations) {
            char command = operate.split(" ")[0].charAt(0);
            int num = Integer.parseInt(operate.split(" ")[1]);
            
            if (command == 'I') {
                maxPQ.offer(num);
                minPQ.offer(num);
            } else {
                if (num == 1) {
                    if (!maxPQ.isEmpty()) {
                        minPQ.remove(maxPQ.poll());
                    }
                } else if (num == -1) {
                    if (!minPQ.isEmpty()) {
                        maxPQ.remove(minPQ.poll());
                    }
                }
            }
        }
        if (!maxPQ.isEmpty()) answer[0] = maxPQ.poll();
        if (!minPQ.isEmpty()) answer[1] = minPQ.poll();
        return answer;
    }
}