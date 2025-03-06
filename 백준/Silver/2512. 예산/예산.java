import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int left = 0;
        int right = 0;
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            right = Math.max(right, arr[i]);
        }
        int M = Integer.parseInt(br.readLine());
        int answer = 0;

        if (sum <= M) {
            System.out.println(right);
        } else {
            while (left < right) {
                // 상한선
                int mid = left + (right - left) / 2;

                int total = 0;
                for (int i = 0; i < N; i++) {
                    if (arr[i] <= mid) {
                        total += arr[i];
                    } else {
                        total += mid;
                    }
                }

                if (total > M) {
                    right = mid;
                } else {
                    answer = mid;
                    left = mid + 1;
                }
            }

            System.out.println(answer);
        }

    }
}
