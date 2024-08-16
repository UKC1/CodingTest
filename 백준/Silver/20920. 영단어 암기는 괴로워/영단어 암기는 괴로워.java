import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        List<String> list = new ArrayList<>(map.keySet());
        list.sort((w1, w2) ->  {
            int cnt = Integer.compare(map.get(w2), map.get(w1));
            if (cnt != 0) {
                return cnt;
            }
            int len = Integer.compare(w2.length(), w1.length());
           if (len != 0) {
               return len;
           }
           return w1.compareTo(w2);
        });

        StringBuilder sb = new StringBuilder();
        for(String s : list) {
            sb.append(s).append("\n");
        }

        System.out.print(sb);
    }
}