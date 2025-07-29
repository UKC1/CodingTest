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
        int N = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        int crossCnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cowNum = Integer.parseInt(st.nextToken());
            int cowDir = Integer.parseInt(st.nextToken());
            if (map.containsKey(cowNum) && map.get(cowNum) != cowDir) {
                crossCnt++;
            }
            map.put(cowNum, cowDir);
        }
        System.out.print(crossCnt);
    }
}
