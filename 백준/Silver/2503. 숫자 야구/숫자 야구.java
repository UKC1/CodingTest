import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            checkArr[i][0] = num;
            checkArr[i][1] = strike;
            checkArr[i][2] = ball;
        }

        permutation(new ArrayList<>(), 0);
        System.out.println(totalCnt);
    }

    static void permutation(List<Integer> list, int idx) {
        if (idx == 3) {
            if (isAnswer(list)) {
                totalCnt++;
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!list.contains(i)) {
                list.add(i);
                permutation(list, idx + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    static boolean isAnswer(List<Integer> list) {
        for (int[] check : checkArr) {
            int num = check[0];
            int strikeCheck = check[1];
            int ballCheck = check[2];

            // strike cnt
            // ball cnt
            int strikeCurrent = 0;
            int ballCurrent = 0;
            int idx = 2;
            while (num > 0) {
                int r = num % 10;
                if (r == list.get(idx)) {
                    strikeCurrent++;
                } else {
                    if (list.contains(r)) {
                        ballCurrent++;
                    }
                }
                num /= 10;
                idx--;
            }

            if (strikeCurrent != strikeCheck || ballCurrent != ballCheck) {
                return false;
            }
        }
        return true;
    }
}

