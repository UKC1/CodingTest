import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            char[] arr = br.readLine().toCharArray();
            int[] cnt = new int[26];
            for (int i = 0; i < arr.length; i++) {
                cnt[arr[i] - 'A']++;
            }
            boolean isTrue = true;
            for (int i = 0; i < cnt.length; i++) {
                if (cnt[i] != 0) {
                    if (cnt[i] != 2) {
                        isTrue = false;
                        break;
                    }
                }
            }
            System.out.println("#" + test_case + " " + (isTrue ? "Yes" : "No"));
        }
    }
}