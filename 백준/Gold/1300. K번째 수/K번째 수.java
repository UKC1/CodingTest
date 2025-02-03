import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int left = 1, right = K, answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long count = countLessOrEqual(N, mid);

            if (count >= K) {
                answer = mid;  // 조건을 만족하는 후보
                right = mid - 1;  // 더 작은 값도 가능할 수 있으므로 left 줄이기
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    // mid 이하의 숫자가 배열에 몇 개 있는지 계산
    static long countLessOrEqual(int N, int mid) {
        long count = 0;
        for (int i = 1; i <= N; i++) {
            count += Math.min(N, mid / i);
        }
        return count;
    }
}