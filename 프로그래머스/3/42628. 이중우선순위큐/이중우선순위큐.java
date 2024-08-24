import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>(); 
        for (String operation : operations) {
            String command = operation.split(" ")[0];
            int num = Integer.parseInt(operation.split(" ")[1]);
            if (command.equals("I")) {
                maxPQ.offer(num);
                minPQ.offer(num);
            } else {
                if (num == 1) {
                    if (maxPQ.isEmpty()) continue;
                    int maxNum = maxPQ.poll();
                    minPQ.remove(maxNum);
                } else if (num == -1) {
                    if (minPQ.isEmpty()) continue;
                    int minNum = minPQ.poll();
                    maxPQ.remove(minNum);
                }
            }
        }
        int[] answer = new int[2];
        if (!maxPQ.isEmpty()) answer[0] = maxPQ.poll();
        if (!minPQ.isEmpty()) answer[1] = minPQ.poll();
        return answer;
    }
}