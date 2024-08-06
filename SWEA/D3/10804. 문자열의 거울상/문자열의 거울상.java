import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            for (int i = str.length() - 1; i >= 0; i--) {
                if (str.charAt(i) == 'b') {
                    sb.append('d');
                } else if (str.charAt(i) == 'd') {
                    sb.append('b');
                } else if (str.charAt(i) == 'p') {
                    sb.append('q');
                } else if (str.charAt(i) == 'q') {
                    sb.append('p');
                }
            }
            System.out.println("#" + test_case + " " + sb.toString());
        }
    }
}