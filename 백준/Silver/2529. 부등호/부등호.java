import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static String[] operators;
    static char[] arr;
    static boolean[] visited;
    static long minNum;
    static long maxNum;
    static String minNumStr;
    static String maxNumStr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        operators = br.readLine().split(" ");
        arr = new char[K + 1];
        visited = new boolean[10];
        minNum = Long.MAX_VALUE;
        maxNum = Long.MIN_VALUE;
        minNumStr = "";
        maxNumStr = "";
        dfs(0);
        System.out.println(maxNumStr);
        System.out.println(minNumStr);
    }
    static boolean isValid() {
        for (int i = 0; i < operators.length; i++) {
            if (operators[i].equals(">")) {
                if (arr[i + 1] >= arr[i]) {
                    return false;
                }
            } else if (operators[i].equals("<")) {
                if (arr[i + 1] <= arr[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void dfs(int idx) {
        if (idx == K + 1) {
            if (isValid()) {
                sb = new StringBuilder();
                for (int i = 0; i < arr.length; i++) {
                    sb.append(arr[i]);
                }
                long num = Long.parseLong(sb.toString());
                if (num < minNum) {
                    minNum = num;
                    minNumStr = sb.toString();
                }

                if (num > maxNum) {
                    maxNum = num;
                    maxNumStr = sb.toString();
                }
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[idx] = Character.forDigit(i, 10);
                dfs(idx + 1);
                visited[i] = false;
            }
        }

    }
}