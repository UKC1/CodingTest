import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int test_case = 1; test_case <= 10; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            char[] arr = st.nextToken().toCharArray();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < arr.length; i++) {
                if (stack.isEmpty()) {
                    stack.push(arr[i]);
                } else if (stack.peek() == arr[i]) {
                    stack.pop();
                } else {
                    stack.push(arr[i]);
                }
            }
            
            StringBuilder sb = new StringBuilder("#" + test_case + " ");
            for (char c : stack) {
                sb.append(c);
            }
            System.out.println(sb.toString());
            
        }
    }
}