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
        int C = Integer.parseInt(st.nextToken());
        int[] homes = new int[N];

        for (int i = 0; i < N; i++) {
            homes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(homes);

        int left = 1;
        int right = homes[N - 1] - homes[0];
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2; 
            int cnt = 1;
            int prev = homes[0];

            for (int i = 1; i < N; i++) {
                if (homes[i] - prev >= mid) {
                    cnt++; 
                    prev = homes[i]; 
                }
            }

            if (cnt >= C) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.print(result);
    }
}