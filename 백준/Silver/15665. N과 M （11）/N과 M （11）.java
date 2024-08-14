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
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		allPermutation(arr, new int[R], 0, sb);
		Set<String> set = new LinkedHashSet<>();
		for (String s : sb.toString().split("\n")) {
			set.add(s);
		}

		sb = new StringBuilder();
		for (String s : set) {
			sb.append(s).append("\n");
		}
		System.out.print(sb);
	}

	static void allPermutation(int[] arr, int[] newArr, int idx, StringBuilder sb) {
		if (idx == newArr.length) {
			for (int i = 0; i < newArr.length; i++) {
				sb.append(newArr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			newArr[idx] = arr[i];
			allPermutation(arr, newArr, idx + 1, sb);
		}
	}
}