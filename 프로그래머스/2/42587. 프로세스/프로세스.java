import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> priorityQ = new ArrayDeque<>();
        Queue<Integer> idxQ = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < priorities.length; i++) {
            priorityQ.offer(priorities[i]);
            list.add(priorities[i]);
            idxQ.offer(i);
        }
        list.sort(Comparator.reverseOrder());
        while(!priorityQ.isEmpty()) {
            int num = priorityQ.poll();
            int idx = idxQ.poll();
            if (num == list.get(0)) {
                if (location == idx) {
                    return priorities.length - priorityQ.size(); 
                }
                list.remove(0);
            } else {
                priorityQ.offer(num);
                idxQ.offer(idx);
            }
        }
        
        return answer;
    }
}