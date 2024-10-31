import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int minCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        minCnt = Integer.MAX_VALUE;
        dfs(A, B, 1);
        System.out.print(minCnt == Integer.MAX_VALUE ? -1 : minCnt);

    }

    static void dfs(long currentNum, long target, int cnt) {
        if (currentNum == target) {
            minCnt = Math.min(minCnt, cnt);
        }

        if (currentNum > target) {
            return;
        }

        dfs(currentNum * 2, target, cnt + 1);
        dfs(currentNum * 10 + 1, target, cnt + 1);
    }
}