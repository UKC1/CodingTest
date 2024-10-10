import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int minV;
    static int maxV;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        
        // 수열 입력
        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 개수 입력
        int[] operators = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        // 최댓값과 최솟값 초기화
        minV = Integer.MAX_VALUE;
        maxV = Integer.MIN_VALUE;

        // DFS 탐색 시작
        dfs(operators, numbers, 1, numbers[0]);

        // 결과 출력
        System.out.println(maxV);
        System.out.println(minV);
    }

    // DFS로 모든 연산 탐색
    static void dfs(int[] operators, int[] numbers, int idx, int sum) {
        if (idx == numbers.length) {
            // 최댓값, 최솟값 업데이트
            minV = Math.min(minV, sum);
            maxV = Math.max(maxV, sum);
            return;
        }

        // 연산자 사용 및 다음 탐색
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                dfs(operators, numbers, idx + 1, calculate(sum, numbers[idx], i));
                operators[i]++;
            }
        }
    }

    // 연산 처리 함수
    static int calculate(int a, int b, int operator) {
        switch (operator) {
            case 0: return a + b; // 더하기
            case 1: return a - b; // 빼기
            case 2: return a * b; // 곱하기
            case 3: return a / b; // 나누기
        }
        return 0; // 기본 리턴
    }
}