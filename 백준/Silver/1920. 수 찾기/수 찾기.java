import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        Set<Integer> visited = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            visited.add(A[i]);
        }
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (visited.contains(num)) {
                sb.append('1');
            } else {
                sb.append('0');
            }

            sb.append('\n');
        }
        System.out.print(sb);
    }
}

