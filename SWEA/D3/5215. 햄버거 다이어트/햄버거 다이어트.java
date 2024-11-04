import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int maxValue;
    static int N;
    static int L;
    static int[][] hamburgers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            maxValue = 0;
            hamburgers = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                hamburgers[i][0] = Integer.parseInt(st.nextToken());
                hamburgers[i][1] = Integer.parseInt(st.nextToken());
            }


            combination(0, 0, 0, 0);
            sb.append("#").append(test_case).append(" ").append(maxValue).append("\n");
        }
        System.out.print(sb);
    }

    static void combination(int idx, int start, int currentCalorie, int value) {
        if (currentCalorie <= L) {
            maxValue = Math.max(maxValue, value);
        }

        for (int i = start; i < N; i++) {
            combination(idx + 1, i + 1, currentCalorie + hamburgers[i][1], value + hamburgers[i][0]);
        }
    }
}