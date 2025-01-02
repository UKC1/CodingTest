import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // N < 2인 경우 결과는 항상 0
        if (N < 2) {
            System.out.println(0);
            return;
        }

        // Step 1: 에라토스테네스의 체로 소수 구하기
        boolean[] isPrime = new boolean[N + 1];
        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= N; i++) isPrime[i] = true;

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        // Step 2: 투 포인터로 연속합 탐색
        int count = 0, sum = 0;
        int start = 0, end = 0;

        while (true) {
            if (sum >= N) {
                sum -= primes.get(start);
                start++;
            } else if (end == primes.size()) {
                break;
            } else {
                sum += primes.get(end);
                end++;
            }

            // N과 같은 경우 카운트 증가
            if (sum == N) {
                count++;
            }
        }

        System.out.println(count);
    }
}