import java.util.Deque;
import java.util.LinkedList;
class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        Deque<String> dequeA = new LinkedList();
        Deque<String> dequeB = new LinkedList();
        for (int i = 0; i < A.length(); i++) {
            dequeA.add(A.charAt(i) + "");
            dequeB.add(B.charAt(i) + "");
        }
        
        while(answer < A.length()) {
            if(dequeB.equals(dequeA)) {
                break;
            }
            dequeA.addFirst(dequeA.removeLast());
            answer++;
        }
        
        if (answer == A.length()) {
            answer = -1;
        }
        return answer;
    }
}