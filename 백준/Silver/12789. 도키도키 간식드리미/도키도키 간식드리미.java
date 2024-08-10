import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		Queue<Integer> currentZone = new LinkedList<>();
		Stack<Integer> emptyZone = new Stack<>();

		for (int i = 0; i < N; i++) {
			currentZone.offer(Integer.parseInt(st.nextToken()));
		}

		int idx = 1;
		while (idx <= N) {
			if (!currentZone.isEmpty() && currentZone.peek() == idx) {
				currentZone.poll();
				idx++;
			} else if (!emptyZone.isEmpty() && emptyZone.peek() == idx) {
				emptyZone.pop();
				idx++;
			} else if (!currentZone.isEmpty()) {
				emptyZone.push(currentZone.poll());
			} else {
				break;
			}
		}

		System.out.print(currentZone.isEmpty() && emptyZone.isEmpty() ? "Nice" : "Sad");
	}
}