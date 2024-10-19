import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());  // 배열 크기
        int M = Integer.parseInt(st.nextToken());  // 나눌 값
        
        int[] culNums = new int[N + 1];            // 누적 합 배열
        int[] remainderCount = new int[M];         // 나머지를 기록할 배열
        long cnt = 0;                              // 나머지가 0인 구간 개수를 카운트할 변수
        
        st = new StringTokenizer(br.readLine());
        
        // 누적 합을 계산하고, 동시에 나머지를 기록
        for (int i = 1; i <= N; i++) {
            culNums[i] = (culNums[i - 1] + Integer.parseInt(st.nextToken())) % M;
            // 나머지가 0인 경우 바로 카운트
            if (culNums[i] == 0) {
                cnt++;
            }
            // 나머지가 같은 구간을 찾기 위해 나머지 카운트 증가
            remainderCount[culNums[i]]++;
        }
        
        // 나머지가 같은 구간 쌍을 찾아 카운트 (조합 공식 nC2)
        for (int i = 0; i < M; i++) {
            if (remainderCount[i] > 1) {
                cnt += (long) remainderCount[i] * (remainderCount[i] - 1) / 2;
            }
        }
        
        System.out.print(cnt);
    }
}