import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		Arrays.sort(arr);
		allCombination(arr, new int[R], 0, 0, sb);
		Set<String> set = new LinkedHashSet<>();
		for(String s : sb.toString().split("\n")) {
			set.add(s);
		}

		sb = new StringBuilder();
		for(String s : set) {
			sb.append(s).append("\n");
		}
		System.out.print(sb);
	}
	static void allCombination(int[] arr, int[] newArr, int idx, int start, StringBuilder sb) {
		if (idx == newArr.length) {
			for (int i = 0; i < newArr.length; i++) {
				sb.append(newArr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < arr.length; i++) {
			newArr[idx] = arr[i];
			allCombination(arr, newArr, idx + 1, i, sb);
		}
	}
}