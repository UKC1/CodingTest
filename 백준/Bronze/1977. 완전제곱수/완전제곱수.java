import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int minNum = Integer.MAX_VALUE;
        int totalSum = 0;
        for (int i = 1; i * i <= N; i++) {
            int squareNum = i * i;
            if (squareNum >= M) {
                if (minNum > squareNum ) {
                    minNum = squareNum;
                }
                totalSum += squareNum;
            }
        }

        if (minNum == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.println(totalSum);
            System.out.println(minNum);
        }
    }
}