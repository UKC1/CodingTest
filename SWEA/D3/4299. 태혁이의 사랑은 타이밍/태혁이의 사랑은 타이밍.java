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
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int hour = Integer.parseInt(st.nextToken());
            int min = Integer.parseInt(st.nextToken());
            sb.append("#").append(test_case).append(" ");

            int diffDay = day - 11;
            int diffHour = hour - 11;
            int diffMin = min - 11;
            int totalMin = diffDay * 24 * 60 + diffHour * 60 + diffMin;
            if(totalMin < 0) totalMin = -1;
            sb.append(totalMin).append("\n");
        }
        System.out.print(sb);
    }
}