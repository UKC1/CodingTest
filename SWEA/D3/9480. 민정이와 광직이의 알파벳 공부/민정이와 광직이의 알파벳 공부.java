import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            cnt = 0;
            int N = Integer.parseInt(br.readLine());
            String[] words = new String[N];
            for (int i = 0; i < N; i++) {
                words[i] = br.readLine();
            }
            for (int R = 1; R <= N; R++) {
                combination(words, "", 0, 0, R);
            }

            sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
        }
        System.out.print(sb);
    }

    static void combination(String[] words, String newWords, int idx, int start, int R) {
        if (idx == R) {
            int[] alphabet = new int[26];
            if (newWords.length() < 26) {
                return;
            }

            for (char c : newWords.toCharArray()) {
                alphabet[c - 'a']++;
            }

            boolean isTrue = true;
            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i] == 0) {
                    isTrue = false;
                    break;
                }
            }
            if (isTrue) cnt++;

            return;
        }

        for (int i = start; i < words.length; i++) {
            combination(words, newWords + words[i], idx + 1, i + 1, R);
        }
    }
}