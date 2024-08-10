import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Deque<Integer> dq = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if (command.equals("push")) {
				dq.offer(Integer.parseInt(st.nextToken()));
			} else if (command.equals("pop")) {
				sb.append(dq.isEmpty() ? -1 : dq.poll()).append("\n");
			} else if (command.equals("size")) {
				sb.append(dq.size()).append("\n");
			} else if (command.equals("empty")) {
				sb.append(dq.isEmpty() ? 1 : 0).append("\n");
			} else if (command.equals("front")) {
				sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append("\n");
			} else if (command.equals("back")) {
				sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append("\n");
			}
		}
		System.out.print(sb);
	}
}