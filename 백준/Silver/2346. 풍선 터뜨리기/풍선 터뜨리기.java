import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		Map<Integer, Integer> map = new HashMap<>();
		Deque<Integer> deque = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			map.put(i, num);
			deque.addLast(i);
		}
		int cnt = 0;
		int K = 0;
		while(!deque.isEmpty()) {
			if (sb.length() < 1) {
				int num = deque.pollFirst();
				sb.append(num).append(" ");
				K = map.get(num);
			}

			if (K > 0) {
				int num = deque.pollFirst();
				cnt++;
				if (cnt == K) {
					sb.append(num).append(" ");
					K = map.get(num);
					cnt = 0;
				} else {
					deque.addLast(num);
				}
			} else {
				int num = deque.pollLast();
				cnt--;
				if (cnt == K) {
					sb.append(num).append(" ");
					K = map.get(num);
					cnt = 0;
				} else {
					deque.addFirst(num);
				}
			}
		}
		System.out.print(sb);
	}
}