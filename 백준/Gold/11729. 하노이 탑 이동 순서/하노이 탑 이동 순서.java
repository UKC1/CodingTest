import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 하노이의 탑 해결 함수 호출
        sb.append((int)(Math.pow(2, N) - 1)).append('\n'); // 이동 횟수는 2^N - 1
        Hanoi(N, 1, 3, 2); // N개의 원판을 1번 기둥에서 3번 기둥으로 옮김
        System.out.println(sb);
    }

    // 재귀적으로 하노이의 탑 이동 과정 출력
    public static void Hanoi(int N, int start, int end, int via) {
        if (N == 1) {
            // 원판 1개를 start에서 end로 이동
            sb.append(start).append(' ').append(end).append('\n');
            return;
        }

        // N-1개의 원판을 start에서 via로 이동
        Hanoi(N - 1, start, via, end);

        // 가장 큰 원판을 start에서 end로 이동
        sb.append(start).append(' ').append(end).append('\n');

        // N-1개의 원판을 via에서 end로 이동
        Hanoi(N - 1, via, end, start);
    }
}