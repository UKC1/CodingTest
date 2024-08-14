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
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		combination(0, M, arr, new int[N], 0);

	}

	public static void combination(int cnt, int depth, int[] arr, int[] newArr, int idx) {
		if (idx == depth) {
			for(int i = 0; i < depth; i++) {
				System.out.print(newArr[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = cnt; i < arr.length; i++) {
			newArr[idx] = arr[i];
			combination(i + 1, depth, arr, newArr, idx + 1);
		}
	}
}