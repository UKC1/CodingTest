import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, Comparator.comparing(arr -> arr[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (String[] book : book_time) {
            int startHour = Integer.parseInt(book[0].split(":")[0]) * 60;
            int startMin = Integer.parseInt(book[0].split(":")[1]);
            int startTime = startHour + startMin;
            
            int endHour = Integer.parseInt(book[1].split(":")[0]) * 60;
            int endMin = Integer.parseInt(book[1].split(":")[1]);
            int endTime = endHour + endMin + 10;
            if (!pq.isEmpty()) {
                if (startTime >= pq.peek()) {
                    pq.poll();
                }
            }
            pq.offer(endTime);
            
        }
        return pq.size();
    }
}