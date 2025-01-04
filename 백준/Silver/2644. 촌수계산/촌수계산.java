import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int firstPerson = Integer.parseInt(st.nextToken());
        int secondPerson = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int[] parent = new int[N + 1];
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree.get(x).add(y);
            tree.get(y).add(x);
        }
        int result = dfs(firstPerson, secondPerson, new boolean[N + 1], tree, 0);
        System.out.print(result);
    }

    static int dfs(int start, int end, boolean[] visited, List<List<Integer>> graph, int depth) {
        visited[start] = true;
        if (start == end) {
            return depth;
        }

        for (Integer next : graph.get(start)) {
            if (!visited[next]) {
                int result = dfs(next, end, visited, graph, depth + 1);
                if (result != -1) {
                    return result;
                }
            }
        }

        return -1;
    }
}