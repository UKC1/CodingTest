import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        
        if (N == 0) {
            System.out.println(0);
            return;
        }

        long[][] result = matrixPower(N - 1);  // F(n) = 행렬[0][0]
        System.out.println(result[0][0]);
    }

    // 반복문을 이용한 피보나치 행렬 거듭제곱 (O(log N))
    private static long[][] matrixPower(long exp) {
        long[][] base = {{1, 1}, {1, 0}}; // 기본 피보나치 행렬
        long[][] result = {{1, 0}, {0, 1}}; // 단위 행렬 (I)

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = multiply(result, base); // 홀수 차수일 때 곱함
            }
            base = multiply(base, base); // 거듭제곱 연산
            exp /= 2;
        }
        return result;
    }

    // 행렬 곱셈 연산 (메모리 최적화)
    private static long[][] multiply(long[][] a, long[][] b) {
        return new long[][] {
            { (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD, (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD },
            { (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD, (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD }
        };
    }
}