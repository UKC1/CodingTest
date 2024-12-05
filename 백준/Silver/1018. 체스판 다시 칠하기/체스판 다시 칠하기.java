import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static char[][] boards;
    static int minCnt = 64;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        char[] blackWhite = new char[8];
        char[] whiteBlack = new char[8];
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                blackWhite[i] = 'B';
                whiteBlack[i] = 'W';
            } else {
                blackWhite[i] = 'W';
                whiteBlack[i] = 'B';
            }
        }


        for (int row = 0; row <= N - 8; row++) {
            for (int col = 0; col <= M - 8; col++) {
                int bCnt = 0;
                int wCnt = 0;
                for (int subRow = row; subRow < row + 8; subRow++) {
                    for (int subCol = col; subCol < col + 8 ; subCol++) {
                        if (subRow % 2 == 0) {
                            if (board[subRow][subCol] != blackWhite[subCol - col]) {
                                bCnt++;
                            }

                            if (board[subRow][subCol] != whiteBlack[subCol - col]) {
                                wCnt++;
                            }
                        } else {
                            if (board[subRow][subCol] != whiteBlack[subCol - col]) {
                                bCnt++;
                            }

                            if (board[subRow][subCol] != blackWhite[subCol - col]) {
                                wCnt++;
                            }
                        }
                    }
                }
                minCnt = Math.min(minCnt, Math.min(bCnt, wCnt));
            }
        }
        System.out.println(minCnt);
    }
}