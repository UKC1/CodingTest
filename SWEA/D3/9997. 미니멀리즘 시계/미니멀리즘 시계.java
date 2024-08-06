import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int theta = Integer.parseInt(br.readLine());
            int totalTime = 2 * theta;
            
            int hour = totalTime / 60;
            int minute = totalTime % 60;
            System.out.println("#" + test_case + " " + hour + " " + minute);
        }
    }
}