import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        boolean[][] whiteBoard = new boolean[101][101];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            for (int row = 0; row < 10; row++) {
                for (int col = 0; col < 10; col++) {
                    whiteBoard[x + row][y + col] = true;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < whiteBoard.length; i++) {
            for (int j = 0; j < whiteBoard[i].length; j++) {
                if(whiteBoard[i][j]) {
                    cnt++;
                }
            }
        }
        System.out.print(cnt);

    }
}