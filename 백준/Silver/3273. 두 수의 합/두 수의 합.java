import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        Arrays.sort(numbers);
        int cnt = 0, start = 0, end = N - 1, sum = 0;
        while (start < end) {
            sum = numbers[start] + numbers[end];
            if (sum == M) {
                cnt++;
            }

            if (sum <= M) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(cnt);
    }
}