import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            int len = str.length() * 4 + 1;
            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < len; j++) {
                    if (i == 2 && j % 4 == 2) {
                        sb.append(str.charAt(cnt++));
                    } else if (i % 2 == 1 && j % 2 != 0) {
                        sb.append("#");
                    } else if ((i + j) % 4 == 2){
                        sb.append("#");
                    } else {
                        sb.append(".");
                    }
                }
                sb.append("\n");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }
}