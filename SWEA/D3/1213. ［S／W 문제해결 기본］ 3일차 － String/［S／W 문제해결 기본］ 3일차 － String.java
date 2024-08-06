import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 1; test_case <= 10; test_case++) {
            int T = Integer.parseInt(br.readLine());
            String findStr = br.readLine();
            String checkStr = br.readLine();
            int beforeLen = checkStr.length();
            checkStr = checkStr.replace(findStr, "");
            int afterLen = checkStr.length();
            System.out.println("#" + test_case + " " + (beforeLen - afterLen) / findStr.length());
        }
    }
}