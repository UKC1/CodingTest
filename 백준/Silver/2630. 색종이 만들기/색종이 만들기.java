import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int zeroCnt;
    static int oneCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] maps = new int[N][N];
        zeroCnt = 0;
        oneCnt = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(maps, 0, N, 0, N);
        System.out.println(zeroCnt);
        System.out.println(oneCnt);
    }

    static void dfs(int[][] maps, int rowStart, int rowEnd, int colStart, int colEnd) {
        int checkNum = check(maps, rowStart, rowEnd, colStart, colEnd);
        if (checkNum != -1) {
            // 모든 숫자가 같으면 0 또는 1 카운트를 증가
            if (checkNum == 0) zeroCnt++;
            else oneCnt++;
            return;
        }

        // 4등분하여 재귀 호출
        int rowMid = (rowStart + rowEnd) / 2;
        int colMid = (colStart + colEnd) / 2;

        dfs(maps, rowStart, rowMid, colStart, colMid); // 1사분면
        dfs(maps, rowStart, rowMid, colMid, colEnd);   // 2사분면
        dfs(maps, rowMid, rowEnd, colStart, colMid);   // 3사분면
        dfs(maps, rowMid, rowEnd, colMid, colEnd);     // 4사분면
    }

    static int check(int[][] maps, int rowStart, int rowEnd, int colStart, int colEnd) {
        int startNum = maps[rowStart][colStart];
        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                if (maps[i][j] != startNum) {
                    return -1; // 섞여 있으면 -1 반환
                }
            }
        }
        return startNum; // 모두 같으면 숫자 반환
    }
}