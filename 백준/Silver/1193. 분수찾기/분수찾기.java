import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        loop: for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                cnt++;
                if (cnt == N) {
                    if (i % 2 == 0) {
                        System.out.print((i - j) + "/" + j + " ");
                    } else {
                        System.out.print(j + "/" + (i - j) + " ");
                    }
                    break loop;
                }
            }
        }

        if (N == 1) System.out.print("1/1");
        else if (N == 2) System.out.print("1/2");
    }
}