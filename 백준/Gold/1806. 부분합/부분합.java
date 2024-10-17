import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int minCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] numbers = new long[N + 1];
        minCnt = Integer.MAX_VALUE;
        int start = -1;
        for (int i = 1; i <= N; i++) {
            numbers[i] = Long.parseLong(st.nextToken());
            numbers[i] += numbers[i - 1];
            if (start == -1 && numbers[i] >= S) {
                start = i;
            }
        }


        if (start != -1) {
            long center = numbers[start];
            minCnt = start;
            while(start < N) {
                for (int i = start - 1; i >= 1; i--) {
                    if (center - numbers[i] >= S) {
                        minCnt = Math.min(minCnt, start - i);
                        break;
                    }
                }
                start++;
                center = numbers[start];
            }
            for (int i = start - 1; i >= 1; i--) {
                if (center - numbers[i] >= S) {
                    minCnt = Math.min(minCnt, start - i);
                    break;
                }
            }
        }
        System.out.print(start == -1 ? 0 : minCnt);
    }
}