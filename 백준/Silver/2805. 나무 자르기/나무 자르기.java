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
        long M = Long.parseLong(st.nextToken());

        long[] trees = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(trees);
        long left = 0;
        long right = trees[N - 1];
        long maxHeight = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long heightSum = 0;
            for (int i = 0; i < trees.length; i++) {
                if (mid < trees[i]) {
                    heightSum += trees[i] - mid;
                }
            }

            if (heightSum < M) {
                right = mid - 1;
            } else {
                maxHeight = Math.max(maxHeight, mid);
                left = mid + 1;
            }
        }

        System.out.print(maxHeight);

    }
}