import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] shares = new long[N];
        long left = 1;
        long right = 0;
        for (int i = 0; i < N; i++) {
            shares[i] = Long.parseLong(br.readLine());
            if (shares[i] > right) {
                right = shares[i];
            }
        }

        long maxLength = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += shares[i] / mid;
            }

            if (cnt >= K) {
                left = mid + 1;
                maxLength = Math.max(maxLength, mid);
            } else {
                right = mid - 1;

            }
        }
        System.out.print(maxLength);

    }
}