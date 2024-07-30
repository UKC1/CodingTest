import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int numberSum = 0;
        while(N > 0) {
            numberSum += N % 10;
            N /= 10;
        }
        System.out.println(numberSum);

    }
}
