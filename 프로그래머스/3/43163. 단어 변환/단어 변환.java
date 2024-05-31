import java.util.*;
class Solution {
    class Node {
        String word;
        int cnt;
        public Node(String word, int cnt) {
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
            Node node = queue.poll();
            if (node.word.equals(target)) {
                return node.cnt;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canChange(node.word, words[i])) {
                    visited[i] = true;
                    queue.offer(new Node(words[i], node.cnt+1));           
                }
            }
        }
        return answer;
    }
    
    public boolean canChange(String beforeWord, String afterWord) {
        int cnt = 0;
        for (int i = 0; i < beforeWord.length(); i++) {
            if (beforeWord.charAt(i) != afterWord.charAt(i)) {
                cnt++;
            }
        }
        
        return cnt == 1;
    }
}

