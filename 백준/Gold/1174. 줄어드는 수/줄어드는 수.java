import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static List<Long> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<Long>();
        /*
        1 10C1
        2 10C2
        3 10C3
        4 10C4
        2 ^ 10 - 1
         */

        if (N > 1023) {
            System.out.println(-1);
        } else {
            combination(0, 0, new StringBuilder());
            Collections.sort(list);
            System.out.println(list.get(N - 1));
        }
    }

    static void combination(int start, int idx, StringBuilder sb) {
        if (idx == 11) {
            return;
        }

        if (sb.length() >= 1) {
            list.add(Long.parseLong(sb.reverse().toString()));
            sb.reverse();
        }

        for (int i = start; i < 10; i++) {
            sb.append(i);
            combination(i + 1, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
