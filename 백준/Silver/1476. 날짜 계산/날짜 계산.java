import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int startE = 0;
        int startS = 0;
        int startM = 0;

        int cnt = 0;
        while(true) {
            if (E == startE && S == startS && M == startM) {
                break;
            }
            startE++;
            startS++;
            startM++;
            cnt++;
            if (startE > 15) startE -= 15;
            if (startS > 28) startS -= 28;
            if (startM > 19) startM -= 19;
        }
        System.out.print(cnt);
    }
}