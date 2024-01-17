import java.util.Deque;
import java.util.LinkedList;
class Solution {
    public int solution(String s) {  
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            Deque<Character> deque = new LinkedList();    
            for (int j = i; j < i + s.length(); j++) {
                char c = s.charAt(j % s.length());
                
                if (c == '[') {
                    deque.push(c);
                } else if (c == '{') {
                    deque.push(c);
                } else if (c == '(') {
                    deque.push(c);
                } else {
                    if (deque.isEmpty()) {
                        deque.add('1');
                        break;
                    } else {
                        if (deque.peek() == '[' && c == ']') {
                            deque.pop();
                        } else if (deque.peek() == '{' && c == '}') {
                            deque.pop();
                        } else if (deque.peek() == '(' && c == ')') {
                            deque.pop();
                        } else {
                            break;
                        }
                    }
                }
            }
            if (deque.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}