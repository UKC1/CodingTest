import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 배열 크기 입력

        int[] arr = new int[N];   // 입력 배열
        int[] result = new int[N]; // 결과 배열 (오큰수 저장)
        Stack<Integer> stack = new Stack<>(); // 인덱스를 저장하는 스택
        int[] cnt = new int[1000001];
        // 배열 입력 처리
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            cnt[arr[i]]++;
        }

        // 스택을 활용한 오큰수 찾기
        for (int i = 0; i < N; i++) {
            // 스택이 비어있지 않고, 현재 숫자가 스택의 top이 가리키는 숫자보다 크다면
            while (!stack.isEmpty() && cnt[arr[stack.peek()]] < cnt[arr[i]]) {
                result[stack.pop()] = arr[i]; // 오큰수 저장
            }
            stack.push(i); // 현재 인덱스를 스택에 저장
        }

        // 스택에 남아 있는 인덱스는 오큰수가 없는 경우이므로 -1 저장
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}