import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        String[] nums = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
        
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();  // 케이스 번호 가져오기 (무시)
            int N = Integer.parseInt(st.nextToken());  // 숫자 갯수
            
            int[] count = new int[10];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                String name = st.nextToken();
                for (int j = 0; j < nums.length; j++) {
                    if (name.equals(nums[j])) {
                        count[j]++;
                        break;
                    }
                }
            }
            
            sb.append("#").append(test_case).append("\n");
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < count[i]; j++) {
                    sb.append(nums[i]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}