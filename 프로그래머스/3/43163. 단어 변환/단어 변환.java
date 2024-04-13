import java.util.*;

class Solution {
    class Node {
        String word;
        int depth;
        public Node(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
    public int solution(String begin, String target, String[] words) {
        Queue<Node> queue = new LinkedList();
        boolean[] visited = new boolean[words.length];
        queue.offer(new Node(begin, 0));
        
        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if(currentNode.word.equals(target)) {
                return currentNode.depth;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (canChange(currentNode.word, words[i]) && !visited[i]) {
                    visited[i] = true;
                    queue.offer(new Node(words[i], currentNode.depth + 1));
                    
                }
            }
            
        }
        return 0;
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