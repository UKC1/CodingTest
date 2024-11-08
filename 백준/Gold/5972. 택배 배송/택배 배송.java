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
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<List<Edge>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Edge>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Edge(v, w));
			graph.get(v).add(new Edge(u, w));
		}
		
		int[] dijkstra = new int[N + 1];
		Arrays.fill(dijkstra, INF);
		dijkstra[1] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getW));
		pq.offer(new Edge(1, 0));
		
		while(!pq.isEmpty()) {
			Edge current = pq.poll();
			int currentV = current.v;
			int currentW = current.w;
			if (dijkstra[currentV] < currentW) continue;
			for (Edge edge : graph.get(currentV)) {
				int newV = edge.v;
				int newW = edge.w;
				int cost = dijkstra[currentV] + newW;
				if (dijkstra[newV] > cost) {
					dijkstra[newV] = cost;
					pq.offer(new Edge(newV, cost));
				}
			}
		}
		System.out.print(dijkstra[N]);
	}
}