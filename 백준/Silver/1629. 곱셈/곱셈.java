import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // 결과 출력
        System.out.println(modularExponentiation(A, B, C));
    }

    // 분할 정복을 사용한 모듈러 거듭제곱
    static long modularExponentiation(long A, long B, long C) {
        if (B == 0) { // B가 0인 경우
            return 1; // A^0 = 1
        }

        long half = modularExponentiation(A, B / 2, C);
        half = (half * half) % C; // 중간 결과를 모듈러 연산

        if (B % 2 != 0) { // B가 홀수인 경우
            half = (half * A) % C;
        }

        return half;
    }
}