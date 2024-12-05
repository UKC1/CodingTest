import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        int minSelfNum = 0;
        int start = N - str.length() * 9;
        for (int num = start; num <= N; num++) {
            int nextNum = selfNum(num);
            if (nextNum == N) {
                minSelfNum = num;
                break;
            }
        }
        System.out.print(minSelfNum);
    }

    static int selfNum(int num) {
        int sum = num;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}