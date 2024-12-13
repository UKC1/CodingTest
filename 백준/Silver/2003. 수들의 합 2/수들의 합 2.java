import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 처리
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 슬라이딩 윈도우 탐색
        int cnt = 0, start = 0, end = 0, partialSum = 0;

        while (true) {
            if (partialSum >= M) {
                partialSum -= numbers[start++];
            } else if (end == N) {
                break;
            } else {
                partialSum += numbers[end++];
            }

            if (partialSum == M) {
                cnt++;
            }
        }

        // 결과 출력
        System.out.println(cnt);
    }
}