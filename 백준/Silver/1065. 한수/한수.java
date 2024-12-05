import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        if (N < 100) {
            System.out.println(N);
        } else {
            int cnt = 99;
            for (int num = 100; num <= N; num++) {
                if (isSequence(num)) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }

    static boolean isSequence(int num) {
        int pre = num % 10;
        num /= 10;
        int next = num % 10;
        int diff = pre - next;
        while (true) {
            pre = next;
            num /= 10;
            next = num % 10;
            if (num == 0) break;
            if (diff != pre - next) {
                return false;
            }
        }
        return true;
    }
}