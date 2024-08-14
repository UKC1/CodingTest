import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		permutation(N, M, new int[N], 0, sb);
		System.out.print(sb);
	}

	static void permutation(int N, int R, int[] arr, int idx, StringBuilder sb) {
		if (idx == R) {
			for (int i = 0; i < R; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[idx] = i + 1;
			permutation(N, R, arr, idx + 1, sb);
		}
	}
}