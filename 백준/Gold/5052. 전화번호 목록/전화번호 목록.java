import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String[] strArr = new String[N];
            for (int j = 0; j < N; j++) {
                String str = br.readLine();
                strArr[j] = str;
            }

            Arrays.sort(strArr);
            boolean isConsistent = true;
            for (int j = 1; j < N; j++) {
                if (strArr[j].startsWith(strArr[j - 1])) {
                    isConsistent = false;
                    break;
                }
            }
            sb.append(isConsistent ? "YES" : "NO").append("\n");
        }
        System.out.print(sb);
    }
}
