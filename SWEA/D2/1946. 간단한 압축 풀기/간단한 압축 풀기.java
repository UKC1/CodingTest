import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            StringBuilder output = new StringBuilder();
            System.out.println("#" + test_case);

            int lineLength = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char character = st.nextToken().charAt(0);
                int count = Integer.parseInt(st.nextToken());

                while (count > 0) {
                    if (lineLength == 10) {
                        output.append('\n');
                        lineLength = 0;
                    }
                    output.append(character);
                    lineLength++;
                    count--;
                }
            }
            output.append('\n');
            System.out.print(output.toString());
        }
    }
}