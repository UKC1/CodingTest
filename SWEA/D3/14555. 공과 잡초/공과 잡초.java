import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int test_case = 1; test_case <= T; test_case++) {
            char[] arr = br.readLine().toCharArray();
            int totalBall = 0;
            for (int i = 0; i < arr.length; i++) {
                char c = arr[i];
                if (c == '(') {
                    if (i < arr.length - 1 && arr[i + 1] == ')' || arr[i + 1] == '|') {
                        totalBall++;
                    }
                } else if (c == ')') {
                    if (i > 0 && arr[i - 1] == '|') totalBall++;
                }
            }
            System.out.println("#" + test_case + " " + totalBall);
        }
    }
}