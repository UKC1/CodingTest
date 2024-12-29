import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N; // 입력으로 주어지는 N번째 감소하는 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N >= 1023) {
            System.out.println(-1); // 감소하는 수가 1022개를 초과하면 존재하지 않음
            return;
        }

        Queue<Long> queue = new LinkedList<>();

        // 0부터 9까지 초기 감소하는 수를 큐에 삽입
        for (long i = 0; i <= 9; i++) {
            queue.offer(i);
        }

        int count = -1; // 감소하는 수의 순서
        long result = -1; // N번째 감소하는 수

        while (!queue.isEmpty()) {
            long current = queue.poll();
            count++;

            // N번째 감소하는 수를 찾으면 종료
            if (count == N) {
                result = current;
                break;
            }

            // 마지막 자릿수보다 작은 숫자를 추가하여 새로운 감소하는 수 생성
            long lastDigit = current % 10;
            for (long nextDigit = 0; nextDigit < lastDigit; nextDigit++) {
                queue.offer(current * 10 + nextDigit);
            }
        }

        System.out.println(result);
    }
}