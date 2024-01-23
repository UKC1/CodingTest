import java.util.Deque;
import java.util.LinkedList;

// cacheSize만큼 보관 시간 지나면 맨 마지막 메모리 소실
// LRU : 가장 오랫동안 참조되지 않은 페이지를 교체
// -> 캐시 hit이 일어나면 나중에 지워지게 끔 맨 뒤로 이동
// -> 캐시 miss라면 miss한 내용은 맨 뒤에 넣고 버퍼가 가득 찼다면 앞은 삭제

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Deque<String> deque = new LinkedList();
        for (int i = 0; i < cities.length; i++) {
            
            deque.addLast(cities[i].toLowerCase());
            String str = deque.pollLast();
            int check = 0;
            for (String s : deque) {
                if (s.equals(str)) {
                    check++;
                    deque.remove(str);
                    break;
                }
            }
        
            if (check == 0) {
                answer += 5;
            } else {
                answer += 1;
            }
            deque.addLast(str);
            
            if (deque.size() > cacheSize) {
                deque.pollFirst();
            }
            // System.out.println(deque + " " + deque.peekLast() + " " + answer);
        }
      
        return answer;
    }
}