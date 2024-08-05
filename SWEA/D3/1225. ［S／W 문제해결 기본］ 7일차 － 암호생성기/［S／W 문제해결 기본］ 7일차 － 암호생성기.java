import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			Deque<Integer> deque = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				deque.offer(Integer.parseInt(st.nextToken()));
			}

			while (deque.peekLast() > 0) {
				for (int cnt = 1; cnt <= 5; cnt++) {
					int num = deque.pollFirst() - cnt;
					if (num <= 0) {
						deque.addLast(0);
						break;
					}
					deque.addLast(num);
				}
			}
			System.out.print("#" + test_case);
			for (Integer num : deque) {
				System.out.print(" " + num);
			}
			System.out.println();
		}
	}
}