import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			int[] arr = new int[10];
			int maxNum = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (maxNum < arr[i]) maxNum = arr[i];
			}
			Arrays.sort(arr);
			double sum = 0;
			for (int i = 1; i < arr.length - 1; i++) {
				sum += arr[i];
			}
			System.out.println("#" + test_case + " " + Math.round(sum / 8));
		}
	}
}