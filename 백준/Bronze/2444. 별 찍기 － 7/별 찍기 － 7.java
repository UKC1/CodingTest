import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = 2 * N - 1;
        for (int i = 0; i < M; i++) {
            int start = Math.max(N - 1, N - 1 + 2 * (i - N + 1));
            int end = Math.min(3 * (N - 1), N - 1 + 2 * i);
            for (int j = 0; j < M; j++) {
                if (i + j >= start && i + j <= end) {
                    System.out.print("*");
                } else if (i + j < start){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}