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
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            int minLen = str.length();
            int repeatedLen = 0;
            for (int i = 0; i < 10; i++) {
                sb.append(str.charAt(i));
                if (str.replace(sb.toString(), "").length() < minLen) {
                    minLen = str.replace(sb.toString(), "").length();
                    repeatedLen = sb.length();
                }
            }
            System.out.println("#" + test_case + " " + repeatedLen);
        }
    }
}