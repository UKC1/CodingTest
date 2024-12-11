import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static boolean[] broken;
    static int minPress;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 고장난 버튼 처리
        broken = new boolean[10];
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int brokenButton = Integer.parseInt(st.nextToken());
                broken[brokenButton] = true;
            }
        }

        // 초기 값 설정 (100에서 +/-로 이동하는 경우)
        minPress = Math.abs(N - 100);

        // 숫자 조합 탐색
        for (int i = 0; i <= 999_999; i++) {
            int pressCount = getPressCount(i);
            if (pressCount > 0) {
                int totalPress = pressCount + Math.abs(i - N);
                minPress = Math.min(minPress, totalPress);
            }
        }

        // 결과 출력
        System.out.println(minPress);
    }

    // 숫자 i를 입력할 수 있는지 확인하고, 가능하면 버튼 누르는 횟수 반환
    static int getPressCount(int num) {
        if (num == 0) {
            return broken[0] ? -1 : 1;
        }

        int pressCount = 0;
        while (num > 0) {
            if (broken[num % 10]) {
                return -1; // 고장난 버튼이 포함된 경우
            }
            pressCount++;
            num /= 10;
        }
        return pressCount;
    }
}