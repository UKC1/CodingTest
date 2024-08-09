import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            map.put(num, i);
        }
        int cnt = 0;
        for(Integer num : map.keySet()) {
            map.put(num, cnt++);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
           sb.append(map.get(arr[i])).append(" ");
        }
        System.out.println(sb);
    }
}