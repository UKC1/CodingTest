import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int maxNum = 0;
        int x = 0;
        int y = 0;
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > maxNum) {
                    maxNum = arr[i][j];
                    x = i;
                    y = j;
                }
            }
        }

        System.out.print(maxNum + "\n" + (x + 1) + " " + (y + 1));
    }
}