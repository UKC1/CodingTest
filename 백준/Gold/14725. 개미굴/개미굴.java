import java.io.*;
import java.util.*;

public class Main {

    static class TrieNode {
        TreeMap<String, TrieNode> children = new TreeMap<>();
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String[] words) {
            TrieNode current = root;
            for (String word : words) {
                current.children.putIfAbsent(word, new TrieNode());
                current = current.children.get(word);
            }
        }

        void print(TrieNode node, int depth) {
            for (String key : node.children.keySet()) {
                for (int i = 0; i < depth; i++) {
                    System.out.print("--");
                }
                System.out.println(key);
                print(node.children.get(key), depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Trie trie = new Trie();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            String[] path = new String[K];
            for (int j = 0; j < K; j++) {
                path[j] = st.nextToken();
            }
            trie.insert(path);
        }

        trie.print(trie.root, 0);
    }
}
