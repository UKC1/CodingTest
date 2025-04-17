import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] classes = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            classes[i] = Integer.parseInt(st.nextToken());
        }
        long maxLen = Long.MAX_VALUE;

        // 모든 기타 강의 동영상을 녹화하는 최소 값
        long left = 0;
        long right = 10000 * 100000;
        while(left <= right) {
            long mid = left + (right - left) / 2;
            int cnt = 0;
            int sum = 0;
            for (int i = 0; i < classes.length; i++) {
                if (sum + classes[i] <= mid) {
                    sum += classes[i];
                } else {
                    cnt++;
                    if (classes[i] <= mid) {
                        sum = classes[i];
                    } else {
                        cnt += M;
                    }
                    if (cnt > M) break;
                }
            }

            if (sum != 0) cnt++;

            if (cnt <= M) {
                right = mid - 1;
                maxLen = Math.min(maxLen, mid);
            } else {
                left = mid + 1;
            }
        }
        System.out.print(maxLen);
    }
}
