import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        // 길이가 1개 부터 전체 까지 조회
        for (int len = 1; len <= N; len++) {
            int partialSum = 0;
            int start = 0;
            int end = len;
            for (int i = start; i < end; i++) {
                partialSum += numbers[i];
            }
            // 슬라이딩 윈도우
            while (true) {
                if (partialSum == M) {
                    cnt++;
                }

                if (end >= N) break;

                partialSum -= numbers[start];
                start++;
                partialSum += numbers[end];
                end++;
            }
        }
        System.out.print(cnt);
    }
}