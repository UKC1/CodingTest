import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        // 2칸 2 ~ 7  6
        // 3칸 8 ~ 19  12
        // 4칸 20 ~ 37  18
        // 5칸 38 ~ 61  24
        int cnt = 2;
        int sum = 7;
        while (sum < N) {
            sum += 6 * cnt;
            cnt++;
        }
        if (N == 1) {
            cnt = 1;
        }
        System.out.println(cnt);

    }
}
