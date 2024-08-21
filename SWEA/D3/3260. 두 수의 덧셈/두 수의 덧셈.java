import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			st = new StringTokenizer(br.readLine());
			char[] A = st.nextToken().toCharArray();
			char[] B = st.nextToken().toCharArray();
			if (A.length >= B.length) {
				int[] sum = arrSum(A, B);
				for (int i = 0; i < sum.length; i++) {
					sb.append(sum[i]);
				}
			} else {
				int[] sum = arrSum(B, A);
				for (int i = 0; i < sum.length; i++) {
					sb.append(sum[i]);
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	static int[] arrSum(char[] longer, char[] shorter) {
		int[] totalSum = new int[longer.length + 1];
		int[] intLong = new int[longer.length + 1];
		int[] intShort = new int[longer.length + 1];
		int longIdx = longer.length - 1;
		int shortIdx = shorter.length - 1;
		
		for (int i = intLong.length - 1; i >= 0; i--) {
			if (longIdx >= 0) {
				intLong[i] = longer[longIdx--] - '0';	
			} else {
				break;
			}
		}
		
		for (int i = intShort.length - 1; i >= 0; i--) {
			if (shortIdx >= 0) {
				intShort[i] = shorter[shortIdx--] - '0';
 			} else {
				break;
			}
		}

		int ten = 0;
		for (int i = totalSum.length - 1; i >= 0; i--) {
			totalSum[i] = intLong[i] + intShort[i] + ten;
			ten = totalSum[i] / 10;
			totalSum[i] = totalSum[i] % 10;
		}
		
		if (totalSum[0] == 0) {
			totalSum = Arrays.copyOfRange(totalSum, 1, totalSum.length);
		}
		
		return totalSum;
	}
}