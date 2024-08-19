import java.util.*;

class Solution {
    class Word {
        String word;
        int cnt;
        
        public Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        Queue<Word> queue = new ArrayDeque<>();
        queue.offer(new Word(begin, 0));
        while(!queue.isEmpty()) {
            Word current = queue.poll();
            String word = current.word;
            int cnt = current.cnt;
            
            if (word.equals(target)) {
                return cnt;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (canChange(word, words[i]) && !visited[i]) {
                    visited[i] = true;
                    queue.offer(new Word(words[i], cnt + 1));
                }
            }
        }
        return 0;
    }
    
    boolean canChange(String before, String after) {
        int cnt = 0;
        for (int i = 0; i < before.length(); i++) {
            if (before.charAt(i) != after.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }
}