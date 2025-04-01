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
        int M = Integer.parseInt(st.nextToken());
        char[][] boards = new char[N][M];
        for (int i = 0; i < N; i++) {
            boards[i] = br.readLine().toCharArray();
        }

        char[][] blackWhite = new char[8][8];
        char[][] whiteBlack = new char[8][8];

        String black = "BWBWBWBW";
        String white = "WBWBWBWB";
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                blackWhite[i] = black.toCharArray();
                whiteBlack[i] = white.toCharArray();
            } else {
                blackWhite[i] = white.toCharArray();
                whiteBlack[i] = black.toCharArray();
            }
        }

        int minWhiteCnt = Integer.MAX_VALUE;
        int minBlackCnt = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int whiteCnt = 0;
                int blackCnt = 0;
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        int curX = x + i;
                        int curY = y + j;
                        if (boards[curX][curY] != blackWhite[x][y]) {
                            blackCnt++;
                        }
                        if (boards[curX][curY] != whiteBlack[x][y]) {
                            whiteCnt++;
                        }
                    }
                }
                if (blackCnt < minBlackCnt) minBlackCnt = blackCnt;
                if (whiteCnt < minWhiteCnt) minWhiteCnt = whiteCnt;
            }
        }
        System.out.print(Math.min(minBlackCnt, minWhiteCnt));
    }
}
