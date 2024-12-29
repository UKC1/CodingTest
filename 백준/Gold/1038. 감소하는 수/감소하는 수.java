import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int cnt;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // N개 짜리 배열
        cnt = 0;
        flag = false;
        // a1 > a2 > ... > aN
        if (N >= 1023) {
            System.out.println(-1);
        } else {
            for (int i = 1; i <= 10; i++) {
                dfs("", 9, 0, i);
                if (flag) break;
            }
        }
    }
    static void dfs(String numStr, int end, int idx, int depth) {
        if (idx == depth) {
            if (cnt == N) {
                System.out.println(numStr);
                flag = true;
            }
            cnt++;
            return;
        }
        if (flag) return;

        for (int i = 0; i <= end; i++) {
            dfs(numStr + i,i - 1, idx + 1, depth);
        }
    }
}