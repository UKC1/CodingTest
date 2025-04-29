import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        char data;
        Node left, right;
        Node(char data) {
            this.data = data;
        }
    }

    static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        root = new Node('A'); // 문제에서 항상 루트는 'A'임
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insert(root, parent, left, right);
        }

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }

    static void insert(Node node, char parent, char left, char right) {
        if (node == null) return;

        if (node.data == parent) {
            if (left != '.') node.left = new Node(left);
            if (right != '.') node.right = new Node(right);
        } else {
            insert(node.left, parent, left, right);
            insert(node.right, parent, left, right);
        }
    }

    static void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data);
        inOrder(node.right);
    }

    static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);
    }
}
