import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int minNum;
    static int maxNum;

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

        // DFS 시작
        dfs(numbers, operators, 1, String.valueOf(numbers[0]));

        // 결과 출력
        System.out.println(maxNum);
        System.out.println(minNum);
    }

    static void dfs(int[] numbers, int[] operators, int idx, String expression) {
        // 모든 숫자를 사용한 경우
        if (idx == numbers.length) {
            int result = evaluate(expression);
            minNum = Math.min(minNum, result);
            maxNum = Math.max(maxNum, result);
            return;
        }

        // 덧셈
        if (operators[0] > 0) {
            operators[0]--;
            dfs(numbers, operators, idx + 1, expression + "+" + numbers[idx]);
            operators[0]++;
        }

        // 뺄셈
        if (operators[1] > 0) {
            operators[1]--;
            dfs(numbers, operators, idx + 1, expression + "-" + numbers[idx]);
            operators[1]++;
        }

        // 곱셈
        if (operators[2] > 0) {
            operators[2]--;
            dfs(numbers, operators, idx + 1, expression + "*" + numbers[idx]);
            operators[2]++;
        }

        // 나눗셈
        if (operators[3] > 0) {
            operators[3]--;
            dfs(numbers, operators, idx + 1, expression + "/" + numbers[idx]);
            operators[3]++;
        }
    }

    static int evaluate(String expression) {
        // 중위 표기식을 후위 표기식으로 변환
        String postfix = infixToPostfix(expression);

        // 후위 표기식 계산
        return evaluatePostfix(postfix);
    }

    static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        StringBuilder numberBuffer = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isDigit(c)) {
                numberBuffer.append(c);
            } else {
                if (numberBuffer.length() > 0) {
                    postfix.append(numberBuffer).append(" ");
                    numberBuffer.setLength(0);
                }

                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
        }

        if (numberBuffer.length() > 0) {
            postfix.append(numberBuffer).append(" ");
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(postfix);

        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            if (token.matches("-?\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(Math.floorDiv(a, b)); // 정수 나눗셈 처리
                        break;
                }
            }
        }

        return stack.pop();
    }
}