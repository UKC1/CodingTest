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
            int max = -1;
            for (int i = 0; i < 10; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (max < num) {
                    max = num;
                }
            }
            System.out.print("#" + test_case + " " + max + "\n");
        }
    }
}