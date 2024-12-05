import java.io.IOException;

public class Main {
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        visited = new boolean[10001];
        for (int num = 1; num <= 10000; num++) {
            if (!visited[num]) {
                sb.append(num).append('\n');
                dfs(num);
            }
        }
        System.out.println(sb);
    }

    static void dfs(int num) {
        visited[num] = true;
        int nextNum = selfNum(num);
        if (nextNum <= 10000) {
            dfs(nextNum);
        }

    }

    static int selfNum(int num) {
        int sum = num;
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}