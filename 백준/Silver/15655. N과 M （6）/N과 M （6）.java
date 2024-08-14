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
		combination(R, arr, new int[N], 0, 0, sb);
		System.out.print(sb);
	}

	static void combination(int R, int[] arr, int[] newArr, int idx, int start, StringBuilder sb) {
		if (idx == R) {
			for (int i = 0; i < R; i++) {
				sb.append(newArr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < newArr.length; i++) {
			newArr[idx] = arr[i];
			combination(R, arr, newArr, idx + 1, i + 1, sb);
		}
	}
}