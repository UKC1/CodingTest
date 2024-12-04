import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int minNum;
    static int maxNum;
    static List<Object> expression = new ArrayList<>(); // 전역으로 사용할 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];

        // 숫자 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 입력
        st = new StringTokenizer(br.readLine());
        int[] operators = new int[4]; // +, -, *, /
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        // 초기값 설정
        minNum = Integer.MAX_VALUE;
        maxNum = Integer.MIN_VALUE;

        // 첫 번째 숫자 추가
        expression.add(numbers[0]);

        // DFS 시작
        dfs(numbers, operators, 1);

        // 결과 출력
        System.out.println(maxNum);
        System.out.println(minNum);
    }

    static void dfs(int[] numbers, int[] operators, int idx) {
        // 모든 숫자를 사용한 경우
        if (idx == numbers.length) {
            int result = evaluate();
            minNum = Math.min(minNum, result);
            maxNum = Math.max(maxNum, result);
            return;
        }

        // 덧셈
        if (operators[0] > 0) {
            operators[0]--;
            expression.add('+');
            expression.add(numbers[idx]);
            dfs(numbers, operators, idx + 1);
            expression.remove(expression.size() - 1); // 백트래킹
            expression.remove(expression.size() - 1); // 백트래킹
            operators[0]++;
        }

        // 뺄셈
        if (operators[1] > 0) {
            operators[1]--;
            expression.add('-');
            expression.add(numbers[idx]);
            dfs(numbers, operators, idx + 1);
            expression.remove(expression.size() - 1); // 백트래킹
            expression.remove(expression.size() - 1); // 백트래킹
            operators[1]++;
        }

        // 곱셈
        if (operators[2] > 0) {
            operators[2]--;
            expression.add('*');
            expression.add(numbers[idx]);
            dfs(numbers, operators, idx + 1);
            expression.remove(expression.size() - 1); // 백트래킹
            expression.remove(expression.size() - 1); // 백트래킹
            operators[2]++;
        }

        // 나눗셈
        if (operators[3] > 0) {
            operators[3]--;
            expression.add('/');
            expression.add(numbers[idx]);
            dfs(numbers, operators, idx + 1);
            expression.remove(expression.size() - 1); // 백트래킹
            expression.remove(expression.size() - 1); // 백트래킹
            operators[3]++;
        }
    }

    static int evaluate() {
        // 1. 곱셈과 나눗셈 먼저 처리
        List<Object> temp = new ArrayList<>();
        int i = 0;

        while (i < expression.size()) {
            if (expression.get(i).equals('*')) {
                int a = (int) temp.remove(temp.size() - 1);
                int b = (int) expression.get(++i);
                temp.add(a * b);
            } else if (expression.get(i).equals('/')) {
                int a = (int) temp.remove(temp.size() - 1);
                int b = (int) expression.get(++i);
                temp.add(a < 0 ? -(-a / b) : a / b); // 음수 나눗셈 처리
            } else {
                temp.add(expression.get(i));
            }
            i++;
        }

        // 2. 덧셈과 뺄셈 처리
        int result = (int) temp.get(0);
        i = 1;

        while (i < temp.size()) {
            char op = (char) temp.get(i++);
            int b = (int) temp.get(i++);

            if (op == '+') {
                result += b;
            } else if (op == '-') {
                result -= b;
            }
        }

        return result;
    }
}