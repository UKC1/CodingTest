import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            Set<Integer> set = new HashSet<>();
            int N = Integer.parseInt(st.nextToken());
            int cnt = 1;
            while (set.size() < 10) {
                int sliceNum = N * cnt;
                while(sliceNum > 0) {
                    set.add(sliceNum % 10);
                    sliceNum /= 10;
                }
                cnt++;
            }
            System.out.println("#" + test_case + " " + (cnt - 1) * N);
        }
    }
}