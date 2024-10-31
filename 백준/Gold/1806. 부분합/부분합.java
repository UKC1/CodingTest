import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 배열의 크기
        int S = Integer.parseInt(st.nextToken()); // 부분합 목표 값

        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 투 포인터와 변수 초기화
        int start = 0, end = 0, sum = 0, minLength = Integer.MAX_VALUE;

        while (true) {
            if (sum >= S) {
                // 합이 S 이상인 경우, 구간 길이를 기록하고 start를 증가시켜 구간을 줄임
                minLength = Math.min(minLength, end - start);
                sum -= numbers[start++];
            } else if (end == N) {
                // end가 배열 끝에 도달하면 종료
                break;
            } else {
                // 합이 S 미만인 경우, end를 증가시켜 구간을 확장
                sum += numbers[end++];
            }
        }

        // 결과 출력 (최소 길이가 갱신되지 않았다면 0 출력)
        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }
}