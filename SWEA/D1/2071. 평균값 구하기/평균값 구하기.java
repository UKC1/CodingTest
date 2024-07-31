import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            double sum = 0;
            for (int j = 0; j < 10; j++) {
                sum += Integer.parseInt(st.nextToken());
            }
            System.out.printf("#%d %.0f\n", i + 1, sum / 10);

        }
    }
}