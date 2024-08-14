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
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		combination(arr, new int[R], 0, 0, sb);
		System.out.print(sb);
	}

	static void combination(int[] arr, int[] newArr, int idx, int start, StringBuilder sb) {
		if (idx == newArr.length) {
			for (int i = 0; i < newArr.length; i++) {
				sb.append(newArr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < arr.length; i++) {
			newArr[idx] = arr[i];
			combination(arr, newArr, idx + 1, i, sb);
		}
	}
}