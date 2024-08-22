import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int gateCnt = 0;
            int continueZero = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] == 0) {
                    continueZero++;
                } else {
                    gateCnt += continueZero / D;
                    continueZero = 0;
                }
            }
            
            gateCnt += continueZero / D;
            sb.append("#").append(test_case).append(" ").append(gateCnt).append("\n");
        }
        System.out.print(sb);
    }

}