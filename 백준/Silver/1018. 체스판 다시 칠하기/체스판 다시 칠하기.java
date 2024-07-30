import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str.split(" ")[0]);
        int M = Integer.parseInt(str.split(" ")[1]);
        int firstNum = 1;

        int minCnt = Integer.MAX_VALUE;
        char[][] arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int bCnt = 0;
                firstNum = 1;
                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        if (arr[k][l] == 'B') {
                            if (firstNum == -1) bCnt++;
                        } else if (arr[k][l] == 'W'){
                            if (firstNum == 1) bCnt++;
                        }
                        firstNum *= -1;
                    }
                    firstNum *= -1;
                }
                minCnt = Math.min(minCnt, Math.min(bCnt, Math.abs(64 - bCnt)));
            }
        }
        System.out.println(minCnt);
    }
}
