import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int[] numbers = new int[7];
			for (int i = 0; i < 7; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());
			combination(numbers, new int[3], 3, 0, 0, set);
			sb.append("#").append(test_case).append(" ");
			int cnt = 5;
			for (Integer num : set) {
				cnt--;
				if (cnt == 0) {
					sb.append(num).append("\n");
					break;
				}
			}
		}
		System.out.print(sb);
	}

	static void combination(int[] numbers, int[] newArr, int R, int idx, int start, Set<Integer> set) {
		if (idx == R) {
			set.add(Arrays.stream(newArr).sum());
			return;
		}

		for (int i = start; i < numbers.length; i++) {
			newArr[idx] = numbers[i];
			combination(numbers, newArr, R, idx + 1, i + 1, set);
		}
	}
}