import java.io.*;
import java.util.*;

public class Main {

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfNumber; // 이 노드에서 번호가 끝났는지

        TrieNode() {
            isEndOfNumber = false;
        }
    }

    static class Trie {
        TrieNode root = new TrieNode();

        // 번호를 트라이에 삽입하면서 일관성 여부를 판단
        boolean insert(String number) {
            TrieNode node = root;
            for (int i = 0; i < number.length(); i++) {
                char ch = number.charAt(i);

                // 만약 중간에 이미 끝나는 번호가 있다면 → 접두어 충돌
                if (node.isEndOfNumber) {
                    return false;
                }

                node = node.children.computeIfAbsent(ch, c -> new TrieNode());
            }

            // 번호 삽입 완료 후, 하위 노드가 있으면 → 내가 다른 번호의 접두어
            if (!node.children.isEmpty()) {
                return false;
            }

            node.isEndOfNumber = true;
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] numbers = new String[N];
            for (int i = 0; i < N; i++) {
                numbers[i] = br.readLine();
            }

            Trie trie = new Trie();
            boolean isConsistent = true;

            for (String number : numbers) {
                if (!trie.insert(number)) {
                    isConsistent = false;
                    break;
                }
            }

            sb.append(isConsistent ? "YES" : "NO").append("\n");
        }

        System.out.print(sb);
    }
}
