import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static String[] operators;
    static boolean[] visited;
    static String minNum = null;
    static String maxNum = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        operators = br.readLine().split(" ");

        visited = new boolean[10]; // 숫자 방문 여부

        // 최소값 탐색
        findNumber("", 0, true);

        // 최대값 탐색
        visited = new boolean[10]; // 방문 초기화
        findNumber("", 0, false);

        System.out.println(maxNum);
        System.out.println(minNum);
    }

    static boolean findNumber(String num, int depth, boolean isMin) {
        if (depth == K + 1) {
            if (isMin) {
                if (minNum == null || num.compareTo(minNum) < 0) {
                    minNum = num;
                }
            } else {
                if (maxNum == null || num.compareTo(maxNum) > 0) {
                    maxNum = num;
                }
            }
            return true; // 값을 찾았으면 종료
        }

        // 탐색 범위 설정
        int start = isMin ? 0 : 9;
        int end = isMin ? 10 : -1;
        int step = isMin ? 1 : -1;

        // 숫자 탐색
        for (int i = start; i != end; i += step) {
            if (!visited[i] && (depth == 0 || isValid(num.charAt(depth - 1) - '0', i, operators[depth - 1]))) {
                visited[i] = true;
                if (findNumber(num + i, depth + 1, isMin)) return true; // 값을 찾으면 탐색 종료
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