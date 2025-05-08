import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] belt = new int[2 * N];
        boolean[] robot = new boolean[N];  // 로봇은 N칸에만 존재

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int step = 0;

        while (true) {
            step++;

            // 1. 벨트와 로봇 함께 회전
            rotate(belt);
            rotate(robot);
            robot[N - 1] = false; // 내리는 위치 로봇 내리기

            // 2. 로봇 이동
            for (int i = N - 2; i >= 0; i--) {
                if (robot[i] && !robot[i + 1] && belt[i + 1] > 0) {
                    robot[i] = false;
                    robot[i + 1] = true;
                    belt[i + 1]--;
                }
            }
            robot[N - 1] = false; // 내리는 위치 로봇 내리기

            // 3. 로봇 올리기
            if (belt[0] > 0) {
                robot[0] = true;
                belt[0]--;
            }

            // 4. 종료 조건 확인
            int zeroCount = 0;
            for (int durability : belt) {
                if (durability == 0) zeroCount++;
            }

            if (zeroCount >= K) break;
        }

        System.out.println(step);
    }

    // 배열 회전 메서드
    static void rotate(int[] arr) {
        int last = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;
    }

    static void rotate(boolean[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = false;  // 새로 올리는 위치에는 로봇 없음
    }
}