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
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            if (a == b && b == c) {
                System.out.println("#" + test_case + " " + a);
            } else if (a == b && b != c) {
                System.out.println("#" + test_case + " " + c);
            } else if (a != b && b == c) {
                System.out.println("#" + test_case + " " + a);
            } else if (a == c && a != b) {
                System.out.println("#" + test_case + " " + b);
            }
        }
    }
}