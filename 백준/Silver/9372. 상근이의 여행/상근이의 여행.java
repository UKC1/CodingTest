import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			List<List<Integer>> graph = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				graph.add(new ArrayList<>());
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				graph.get(u).add(v);
				graph.get(v).add(u);
			}
			
			boolean[] visited = new boolean[N + 1];
			int cnt = 0;
			Queue<Integer> queue = new ArrayDeque<>();
			queue.offer(1);
			visited[0] = true;
			visited[1] = true;
			while(!queue.isEmpty()) {
				int curr = queue.poll();
				for (Integer next : graph.get(curr)) {
					if (!visited[next]) {
						visited[next] = true;
						queue.offer(next);
						cnt++;
					}
				}
			}
			
			sb.append(cnt).append('\n');
		}
		System.out.print(sb);
	}
}