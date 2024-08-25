import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int diagonal = 1; // 현재 대각선
        int sum = 0; // 대각선의 합을 추적

        // N번째 요소가 위치한 대각선을 찾음
        while (sum < N) {
            sum += diagonal;
            diagonal++;
        }

        diagonal--;  // while문이 한 번 더 실행되므로 대각선을 1 감소시킴
        int offset = N - (sum - diagonal);  // 해당 대각선 내에서 N의 위치

        int numerator, denominator;
        if (diagonal % 2 == 0) {  // 대각선이 짝수일 경우
            numerator = offset;
            denominator = diagonal + 1 - offset;
        } else {  // 대각선이 홀수일 경우
            numerator = diagonal + 1 - offset;
            denominator = offset;
        }

        System.out.println(numerator + "/" + denominator);
    }
}