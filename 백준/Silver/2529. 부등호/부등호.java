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

        // 최소값 탐색
        findMin(0, "");

        // 최대값 탐색
        visited = new boolean[10]; // 방문 초기화
        findMax(0, "");

        System.out.println(maxNum);
        System.out.println(minNum);
    }

    // 최소값 탐색
    static boolean findMin(int depth, String num) {
        if (depth == K + 1) {
            minNum = num;
            return true; // 최소값을 찾았으면 탐색 종료
        }

        for (int i = 0; i <= 9; i++) {
            if (!visited[i] && (depth == 0 || isValid(num.charAt(depth - 1) - '0', i, operators[depth - 1]))) {
                visited[i] = true;
                if (findMin(depth + 1, num + i)) return true; // 최소값을 찾았으면 더 탐색하지 않음
                visited[i] = false;
            }
        }
        return false;
    }

    // 최대값 탐색
    static boolean findMax(int depth, String num) {
        if (depth == K + 1) {
            maxNum = num;
            return true; // 최대값을 찾았으면 탐색 종료
        }

        for (int i = 9; i >= 0; i--) {
            if (!visited[i] && (depth == 0 || isValid(num.charAt(depth - 1) - '0', i, operators[depth - 1]))) {
                visited[i] = true;
                if (findMax(depth + 1, num + i)) return true; // 최대값을 찾았으면 더 탐색하지 않음
                visited[i] = false;
            }
        }
        return false;
    }

    static boolean isValid(int prev, int curr, String operator) {
        if (operator.equals(">")) {
            return prev > curr;
        } else {
            return prev < curr;
        }
    }
}