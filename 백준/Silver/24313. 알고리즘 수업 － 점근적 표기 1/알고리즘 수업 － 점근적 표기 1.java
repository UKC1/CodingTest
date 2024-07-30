import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int n0 = Integer.parseInt(st.nextToken());
        boolean isTrue = true;
        for (int i = n0; i <= 100; i++) {
            if (a1 * i + a0 > c * i) {
                isTrue = false;
                break;
            }
        }
        System.out.println(isTrue ? 1 : 0);
    }
}
