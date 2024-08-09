import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dayNum = {3, 4, 5, 6, 0, 1, 2};
        int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            int month = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            int totalDays = day;
            for (int i = 0; i < month; i++) {
                totalDays += days[i];
            }
            sb.append("#" + test_case).append(" " + dayNum[totalDays % 7] + "\n");
            System.out.print(sb);
        }
    }
}