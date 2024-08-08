import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int test_case = 1; test_case <= 10; test_case++) {
            int limitCnt = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] heights = new int[100];
            for (int i = 0; i < 100; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            while (cnt < limitCnt) {
                Arrays.sort(heights);
                if (heights[99] - heights[0] <= 1) break;
                heights[99]--;
                heights[0]++;
                cnt++;
            }
            Arrays.sort(heights);
            System.out.println("#" + test_case + " " + (heights[99] - heights[0]));
        }
    }
}