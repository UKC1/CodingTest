import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new TreeMap<>();
        int cnt = 0;
        for (int i = 0; i < N + M; i++) {
            String name = br.readLine();
            if (map.containsKey(name)) {
                map.put(name, 2);
                cnt++;
            } else {
                map.put(name, 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append('\n');
        for(String name : map.keySet()) {
            if (map.get(name) == 2) {
                sb.append(name).append('\n');
            }
        }
        System.out.print(sb);
    }
}