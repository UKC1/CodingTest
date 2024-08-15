import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Deque<Integer> deque = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		int x = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int firstNum = Integer.parseInt(st.nextToken());
			if (firstNum == 1 || firstNum == 2) {
				x = Integer.parseInt(st.nextToken());
			}
			switch (firstNum) {
				case 1:
					deque.addFirst(x);
					break;
				case 2:
					deque.addLast(x);
					break;
				case 3:
					sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
					break;
				case 4:
					sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
					break;
				case 5:
					sb.append(deque.size()).append("\n");
					break;
				case 6:
					sb.append(deque.isEmpty() ? 1 : 0).append("\n");
					break;
				case 7:
					sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
					break;
				case 8:
					sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
					break;
				default:
					break;
			}
		}
		System.out.print(sb);
	}
}