import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] coins = {25, 10, 5, 1};
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int[] cnt = new int[4];
            int idx = 0;
            while(money > 0) {
                cnt[idx] = money / coins[idx];
                money = money % coins[idx];
                idx++;
            }
            for(int coinCnt : cnt) {
                System.out.print(coinCnt + " ");
            }
            System.out.println();
        }
    }
}