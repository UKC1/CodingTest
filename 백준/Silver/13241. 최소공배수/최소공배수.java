import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        System.out.print(lcm(A, B));
    }

    static long gcd(long a, long b) {
        if (a % b == 0) {
            return b;
        }

        return gcd (b, a % b);
    }

    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}