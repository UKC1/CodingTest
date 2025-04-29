import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        for (int test = 0; test < T; test++) {
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                String[] strArr = br.readLine().split(" ");
                map.put(strArr[1], map.getOrDefault(strArr[1], 0) + 1);
            }

            int sum = 1;
            for (String key : map.keySet()) {
                sum *= (map.get(key) + 1);
            }
            sum -= 1;
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
