import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        queue.offer(new Node(begin, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.word.equals(target)) {
                return current.depth;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canChange(current.word, words[i])) {
                    visited[i] = true;
                    queue.offer(new Node(words[i], current.depth + 1));
                }
            }
        }

        return 0;  // target을 만들 수 없는 경우
    }

    private boolean canChange(String current, String next) {
        int count = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != next.charAt(i)) {
                count++;
            }
        }
        return count == 1;  // 한 글자만 다른 경우 true
    }

    class Node {
        String word;
        int depth;

        Node(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
}
