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
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> strMap = new HashMap<>();
        Map<Integer, String> idxMap = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String pokemon = br.readLine();
            strMap.put(pokemon, i);
            idxMap.put(i, pokemon);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String quiz = br.readLine();
            if (quiz.charAt(0) >= '0' && quiz.charAt(0) <= '9') {
                sb.append(idxMap.get(Integer.parseInt(quiz))).append("\n");
            } else {
                sb.append(strMap.get(quiz)).append("\n");
            }
        }
        System.out.print(sb);
    }
}