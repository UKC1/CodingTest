import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            char[] cards = br.readLine().toCharArray();
            int[] S = new int[14];
            int[] D = new int[14];
            int[] H = new int[14];
            int[] C = new int[14];
            cardInit(S);
            cardInit(D);
            cardInit(H);
            cardInit(C);


            boolean isTrue = true;
            for (int i = 0; i < cards.length; i+=3) {
                if (cards[i] == 'S') {
                    if (!cardCheck(i, cards, S)) {
                        isTrue = false;
                        break;
                    }
                } else if (cards[i] == 'D') {
                    if (!cardCheck(i, cards, D)) {
                        isTrue = false;
                        break;
                    }
                } else if (cards[i] == 'H') {
                    if (!cardCheck(i, cards, H)) {
                        isTrue = false;
                        break;
                    }
                } else if (cards[i] == 'C') {
                    if (!cardCheck(i, cards, C)) {
                        isTrue = false;
                        break;
                    }
                }
            }

            int sCnt = cardCnt(S);
            int dCnt = cardCnt(D);
            int hCnt = cardCnt(H);
            int cCnt = cardCnt(C);

            sb.append("#").append(test_case);
            sb.append(isTrue ? " " + sCnt + " " + dCnt + " " + hCnt + " " + cCnt : " ERROR");
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void cardInit(int[] N) {
        for (int i = 1; i < N.length; i++) {
            N[i] = 1;
        }
    }
    static int cardCnt(int[] N) {
        int cnt = 0;
        for (int i = 1; i < N.length; i++) {
            if (N[i] == 1) {
                cnt++;
            }
        }
        return cnt;
    }
    static boolean cardCheck(int idx, char[] cards, int[] N) {
        int ten = cards[idx + 1] - '0';
        int one = cards[idx + 2] - '0';
        int num = ten * 10 + one;
        N[num]--;
        if (N[num] < 0) return false;
        return true;
    }
}