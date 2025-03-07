import java.io.*;
import java.util.*;

public class Main {
    static int[][] checkArr;
    static int totalCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        checkArr = new int[N][3];
        totalCnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            checkArr[i][0] = Integer.parseInt(st.nextToken()); // 숫자
            checkArr[i][1] = Integer.parseInt(st.nextToken()); // 스트라이크
            checkArr[i][2] = Integer.parseInt(st.nextToken()); // 볼
        }

        permutation(new int[3], new boolean[10], 0);
        System.out.println(totalCnt);
    }

    static void permutation(int[] list, boolean[] used, int idx) {
        if (idx == 3) {
            if (isAnswer(list)) {
                totalCnt++;
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!used[i]) {
                used[i] = true;
                list[idx] = i;
                permutation(list, used, idx + 1);
                used[i] = false;
            }
        }
    }

    static boolean isAnswer(int[] list) {
        for (int[] check : checkArr) {
            int num = check[0];
            int strikeExpected = check[1];
            int ballExpected = check[2];

            int strikeCount = 0;
            int ballCount = 0;

            int[] numArr = { num / 100, (num / 10) % 10, num % 10 };

            for (int i = 0; i < 3; i++) {
                if (numArr[i] == list[i]) {
                    strikeCount++;
                } else if (list[0] == numArr[i] || list[1] == numArr[i] || list[2] == numArr[i]) {
                    ballCount++;
                }
            }

            if (strikeCount != strikeExpected || ballCount != ballExpected) {
                return false;
            }
        }
        return true;
    }
}
