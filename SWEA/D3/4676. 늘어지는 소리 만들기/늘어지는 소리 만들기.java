import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            int H = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] cnt = new int[str.length() + 1];
            for (int i = 0; i < H; i++) {
                int position = Integer.parseInt(st.nextToken());
                cnt[position]++;
            }

            sb.append("#").append(test_case).append(" ");
            for (int i = 0; i < str.length(); i++) {
                if (cnt[i] > 0) {
                    for (int j = 0; j < cnt[i]; j++) {
                        sb.append("-");
                    }
                    sb.append(str.charAt(i));
                } else {
                    sb.append(str.charAt(i));
                }
            }

            if (cnt[str.length()] > 0) {
                for(int i = 0; i < cnt[str.length()]; i++) {
                    sb.append("-");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}