import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
		permutation(arr, new int[N], new boolean[N], 0, R, sb);
		System.out.print(sb);
	}

	static void permutation(int[] arr, int[] newArr, boolean[] visited, int idx, int R, StringBuilder sb) {
		if (idx == R) {
			for (int i = 0; i < R; i++) {
				sb.append(newArr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				newArr[idx] = arr[i];
				permutation(arr, newArr, visited, idx + 1, R, sb);
				visited[i] = false;
			}
		}
	}
}