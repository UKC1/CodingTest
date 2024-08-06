import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            String numStr = br.readLine();
            int digitOne = numStr.charAt(numStr.length() - 1) - '0';
            System.out.println("#" + test_case + " " + (digitOne % 2 == 0 ? "Even" : "Odd"));
        }
    }
}