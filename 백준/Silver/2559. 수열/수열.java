import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 처리
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 숫자의 개수
        int K = Integer.parseInt(st.nextToken()); // 연속 구간의 크기
        
        int[] culNums = new int[N + 1]; // 누적 합 배열
        st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= N; i++) {
            culNums[i] = Integer.parseInt(st.nextToken());
            culNums[i] += culNums[i - 1]; // 누적 합 계산
        }
        
        // 첫 번째 구간을 이용해 최대 구간 합 초기화
        int maxSum = culNums[K] - culNums[0];
        
        // K개의 연속 구간 중 최대 합 구하기
        for (int i = 1; i <= N - K; i++) {
            int currentSum = culNums[K + i] - culNums[i];
            maxSum = Math.max(maxSum, currentSum); // 최대 합 갱신
        }
        
        System.out.print(maxSum);
    }
}