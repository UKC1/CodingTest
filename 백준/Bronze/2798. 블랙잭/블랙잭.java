import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] cards;
    static int maxSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cards = new int[N];
        maxSum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        combination(0, 0, 0);
        System.out.print(maxSum);
    }

    static void combination(int idx, int start, int sum) {
        if (idx == 3) {
            if (sum <= M && maxSum < sum) {
                maxSum = sum;
            }
            return;
        }

        for (int i = start; i < N; i++) {
            combination(idx + 1, i + 1, sum + cards[i]);
        }
    }
}