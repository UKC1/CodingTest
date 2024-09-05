import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null && !str.equals("")) {
            int N = Integer.parseInt(str);
            int len = (int) Math.pow(3, N);  // 길이는 3^N
            char[] strSb = new char[len];

            // 초기에는 모든 구간을 '-'로 채움
            for (int i = 0; i < len; i++) {
                strSb[i] = '-';
            }

            // 재귀적으로 구간을 공백으로 변경
            canTour(strSb, 0, len);

            // 결과 출력
            System.out.println(new String(strSb));
        }
    }

    static void canTour(char[] strSb, int start, int len) {
        if (len == 1) return;  // 더 이상 나눌 수 없는 경우 종료

        int subLen = len / 3;  // 3등분할 길이
        // 중간 구간을 공백으로 채움
        for (int i = start + subLen; i < start + subLen * 2; i++) {
            strSb[i] = ' ';
        }

        // 좌, 우 구간에 대해 재귀 호출
        canTour(strSb, start, subLen);                  // 첫 번째 구간
        canTour(strSb, start + subLen * 2, subLen);     // 세 번째 구간
    }
}