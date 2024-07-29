import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstLen = Integer.parseInt(st.nextToken());
        int secondLen = Integer.parseInt(st.nextToken());
        int thirdLen = Integer.parseInt(st.nextToken());

        int maxLen = Math.max(firstLen, Math.max(secondLen, thirdLen));
        int sum = firstLen + secondLen + thirdLen;
        if (sum - maxLen > maxLen) {
            System.out.println(sum);
        } else {
            sum = sum - maxLen;
            sum = sum * 2 - 1;
            System.out.println(sum);
        }
    }
}
