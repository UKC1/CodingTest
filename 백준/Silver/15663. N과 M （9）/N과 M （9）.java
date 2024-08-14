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
		permutation(arr, new int[R], new boolean[N], 0, sb);
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

	static void permutation(int[] arr, int[] newArr, boolean[] viisted, int idx, StringBuilder sb) {
		if (idx == newArr.length) {
			for (int i = 0; i < newArr.length; i++) {
				sb.append(newArr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if(!viisted[i]) {
				viisted[i] = true;
				newArr[idx] = arr[i];
				permutation(arr, newArr, viisted, idx + 1, sb);
				viisted[i] = false;
			}
		}
	}
}