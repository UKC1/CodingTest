import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static class Edge {
		int v, w;
		Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		int getW() {
			return this.w;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		List<List<Edge>> graph = new ArrayList<>();
		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}
		int[] dijkstra = new int[V + 1];
		Arrays.fill(dijkstra, INF);
		dijkstra[start] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getW));
		pq.offer(new Edge(start, 0));
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Edge(v, w));
		}
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (curr.w < dijkstra[curr.v]) continue;
			
			for (Edge next : graph.get(curr.v)) {
				if (dijkstra[next.v] > dijkstra[curr.v] + next.w) {
					dijkstra[next.v] = dijkstra[curr.v] + next.w;
					pq.offer(new Edge(next.v, dijkstra[next.v]));
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			if (dijkstra[i] == INF) {
				sb.append("INF").append('\n');
			} else {
				sb.append(dijkstra[i]).append('\n');
			}
		}
		System.out.print(sb);
		
	}
}