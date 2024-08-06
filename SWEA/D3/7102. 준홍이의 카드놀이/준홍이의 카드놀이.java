import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] numCnt = new int[N + M + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    numCnt[i + j]++;
                }
            }
            int maxCnt = 0;
            for (int i = 2; i < numCnt.length; i++) {
                if (numCnt[i] > maxCnt) maxCnt = numCnt[i];
            }

            System.out.print("#" + test_case);
            for (int i = 2; i < numCnt.length; i++) {
                if (numCnt[i] == maxCnt) {
                    System.out.print(" " + i);
                }
            }
            System.out.println();
        }
    }
}