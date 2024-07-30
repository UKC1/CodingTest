import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        int num = Integer.parseInt(str);
        int startNum = num - 9 * len;
        boolean isTrue = false;
        while (startNum < num) {
            int original = startNum;
            int cnt = len;
            int sum = original;
            while(cnt > 0) {
                sum += original % 10;
                original /= 10;
                cnt--;
            }

            if (sum == num) {
                isTrue = true;
                break;
            }
            startNum++;
        }

        System.out.println(isTrue ? startNum : 0);


    }
}
