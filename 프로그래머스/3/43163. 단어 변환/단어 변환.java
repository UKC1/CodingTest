import java.util.*;

class Solution {
    class Node {
        private String word;
        private int changedCnt; 

        Node(String word, int changedCnt) {
            this.word = word;
            this.changedCnt = changedCnt;
        }
     }
   
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Node> queue = new LinkedList();
        queue.add(new Node(begin, 0));
        boolean[] visited = new boolean[words.length];
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            if (target.equals(current.word)) {
                return current.changedCnt;
            }
            
            for (int i = 0; i < words.length; i++) {
                if(!visited[i] && canChange(current.word, words[i])) {
                    visited[i] = true;
                    queue.add(new Node(words[i], current.changedCnt + 1));
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
