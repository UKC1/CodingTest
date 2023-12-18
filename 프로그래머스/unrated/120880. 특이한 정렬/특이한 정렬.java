import java.util.Arrays;
import java.util.TreeMap;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];        
        TreeMap<Integer, Integer> map = new TreeMap();
        Stack<Integer> minus = new Stack();
        Queue<Integer> plus = new LinkedList();
    
        for (int i = 0; i < numlist.length; i++) {
            map.put(numlist[i] - n, numlist[i]);
        }
    
        int idx = 0;
        for (Integer i : map.keySet()) {
            if (i < 0) {
                minus.push(i);
            } else {
                plus.add(i);
            }
        }
        
        while (minus.size() > 0 && plus.size() > 0) {
           if (- minus.peek() > plus.peek()) {
                answer[idx++] = map.get(plus.poll());
            } else if (- minus.peek() < plus.peek()) {
                answer[idx++] = map.get(minus.pop());
            } else {
               answer[idx++] = map.get(plus.poll());
               answer[idx++] = map.get(minus.pop());
           }
            
        }
        
        while(minus.size() > 0) {
            answer[idx++] = map.get(minus.pop());
        }
        
        while(plus.size() > 0) {
            answer[idx++] = map.get(plus.poll());
        }
        
        return answer;
    }
}