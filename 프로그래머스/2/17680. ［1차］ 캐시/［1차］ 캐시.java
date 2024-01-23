import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Deque<String> deque = new LinkedList();
        for (int i = 0; i < cities.length; i++) {
            
            deque.addLast(cities[i].toLowerCase());
            String str = deque.pollLast();
            boolean isHit = false;
            for (String s : deque) {
                if (s.equals(str)) {
                    isHit = true;
                    deque.remove(str);
                    break;
                }
            }
        
            if (isHit) {
                answer += 1;
            } else {
                answer += 5;
            }
            deque.addLast(str);
            
            if (deque.size() > cacheSize) {
                deque.pollFirst();
            }
        }
      
        return answer;
    }
}