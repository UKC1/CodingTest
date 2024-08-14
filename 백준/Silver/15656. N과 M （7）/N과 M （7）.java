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
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		Arrays.sort(arr);
		allPermutation(R, 0, arr, new int[R], sb);
		System.out.print(sb);
	}
	static void allPermutation(int R, int idx, int[] arr, int[] newArr, StringBuilder sb) {
		if (idx == R) {
			for (int i = 0; i < R; i++) {
				sb.append(newArr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			newArr[idx] = arr[i];
			allPermutation(R, idx + 1, arr, newArr, sb);
		}
	}
}