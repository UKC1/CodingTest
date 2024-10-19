import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 문자열
        String str = br.readLine();
        int len = str.length();
        
        // 누적 합 배열 선언: 26개의 알파벳 각각에 대해 [0...len] 구간 저장
        int[][] prefixSum = new int[26][len + 1];

        // 각 알파벳별로 누적 합 계산
        for (int i = 0; i < len; i++) {
            int charIndex = str.charAt(i) - 'a';  // 알파벳 인덱스 계산 ('a' -> 0, 'b' -> 1, ...)
            
            // 현재 위치까지의 누적 합을 복사
            for (int j = 0; j < 26; j++) {
                prefixSum[j][i + 1] = prefixSum[j][i];
            }
            
            // 현재 문자의 누적 합 증가
            prefixSum[charIndex][i + 1]++;
        }
        
        // 쿼리 수 입력
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        // 각 쿼리 처리
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            int charIndex = c - 'a';  // 쿼리에서 찾는 문자의 인덱스 계산
            
            // 해당 문자의 구간 [start, end]에서 등장 횟수는 prefixSum 배열을 사용해 계산
            int result = prefixSum[charIndex][end + 1] - prefixSum[charIndex][start];
            sb.append(result).append("\n");
        }
        
        // 결과 출력
        System.out.print(sb);
    }
}