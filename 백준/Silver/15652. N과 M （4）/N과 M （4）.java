import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		allCombination(N, R, new int[N], 0, 0, sb);
		System.out.print(sb);
	}

	static void allCombination(int N, int R, int[] arr, int idx, int start, StringBuilder sb) {
		if (idx == R) {
			for (int i = 0; i < R; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < N; i++) {
			arr[idx] = i + 1;
			allCombination(N, R, arr, idx + 1, i, sb);
		}
	}
}