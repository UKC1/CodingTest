import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[10];
			int max = 0;
			int min = 1000001;
			for (int i = 0; i < 10; i++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i] = allNumSum(num);
				if (max < arr[i]) max = arr[i];
				if (min > arr[i]) min = arr[i];
			}
			System.out.println("#" + test_case + " " + max + " " + min);
		}
	}
	
	public static int allNumSum(int num) {
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}
}