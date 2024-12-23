import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static String[] operators;
    static boolean[] visited;
    static String minNum = "";
    static String maxNum = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        operators = br.readLine().split(" ");

        visited = new boolean[10]; // 숫자 방문 여부

        dfs("", 0); // 순열 생성 시작

        System.out.println(maxNum);
        System.out.println(minNum);
    }

    static void dfs(String num, int depth) {
        if (depth == K + 1) { // K+1 자리 숫자를 완성
            if (minNum.isEmpty() || num.compareTo(minNum) < 0) {
                minNum = num;
            }
            if (maxNum.isEmpty() || num.compareTo(maxNum) > 0) {
                maxNum = num;
            }
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                // 이전 숫자와 부등호 조건 확인
                if (depth == 0 || isValid(num.charAt(depth - 1) - '0', i, operators[depth - 1])) {
                    visited[i] = true;
                    dfs(num + i, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    static boolean isValid(int prev, int curr, String operator) {
        if (operator.equals(">")) {
            return prev > curr;
        } else {
            return prev < curr;
        }
    }
}