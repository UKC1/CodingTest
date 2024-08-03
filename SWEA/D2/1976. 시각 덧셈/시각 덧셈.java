import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startHour = Integer.parseInt(st.nextToken());
            int startMin = Integer.parseInt(st.nextToken());
            int endHour = Integer.parseInt(st.nextToken());
            int endMin = Integer.parseInt(st.nextToken());

            int sumHour = startHour + endHour;
            int sumMin = startMin + endMin;

            // 분을 시간으로 변환
            sumHour += sumMin / 60;
            int min = sumMin % 60;

            // 12시간제로 변환
            int hour = sumHour % 12;
            if (hour == 0) {
                hour = 12;
            }

            System.out.println("#" + test_case + " " + hour + " " + min);
        }
    }
}