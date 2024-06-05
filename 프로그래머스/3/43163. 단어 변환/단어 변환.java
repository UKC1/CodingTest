import java.util.*;

class Solution {
    class Node {
        String word;
        int cnt;
        Node(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];    
        Queue<Node> queue = new LinkedList();
        queue.offer(new Node(begin, 0));
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            
            if (current.word.equals(target)) {
                return current.cnt;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canChange(current.word, words[i])) {
                    visited[i] = true;
                    queue.offer(new Node(words[i], current.cnt + 1));
                    
                }
            }
            
        }
        return answer;
    }
    
    public boolean canChange(String begin, String word) {
        int cnt = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != word.charAt(i)) {
                cnt++;
            }
        }
        
        return cnt == 1;
    }
}