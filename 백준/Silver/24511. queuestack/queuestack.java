import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] stackQueueState = new int[N];
		for (int i = 0; i < N; i++) {
			stackQueueState[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		Deque<Integer> currentDeque = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (stackQueueState[i] == 0) {
				currentDeque.offer(num);
			}
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			queue.offer(Integer.parseInt(st.nextToken()));
		}
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			int num = queue.poll();
			currentDeque.addFirst(num);
			sb.append(currentDeque.pollLast()).append(" ");
		}
		System.out.print(sb);
	}
}