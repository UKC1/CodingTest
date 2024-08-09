import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();

            if (state.equals("enter")) {
                set.add(name);
            } else if (state.equals("leave") && set.contains(name)) {
                set.remove(name);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String name : set) {
            sb.append(name).append("\n");
        }
        System.out.print(sb);
    }
}