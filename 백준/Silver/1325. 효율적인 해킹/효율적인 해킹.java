import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> edges;
    static int maxInt;
    static int localInt;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        edges = new ArrayList<List<Integer>>();
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int sub = Integer.parseInt(st.nextToken());
            int main = Integer.parseInt(st.nextToken());
            edges.get(main).add(sub);
        }

        maxInt = 0;
        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            localInt = 1;
            visited[i] = true;
            dfs(i, visited);
            if (maxInt < localInt) {
                maxInt = localInt;
                list.clear();
                list.add(i);
            } else if (maxInt == localInt) {
                list.add(i);
            }
        }

        for (Integer num : list) {
            sb.append(num).append(" ");
        }
        System.out.print(sb);
    }

    static void dfs(int vertex, boolean[] visited) {
        for (Integer next : edges.get(vertex)) {
            if (!visited[next]) {
                visited[next] = true;
                localInt++;
                dfs(next, visited);
            }
        }
    }
}