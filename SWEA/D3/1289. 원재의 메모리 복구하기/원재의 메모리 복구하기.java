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
			char[] strToChar = br.readLine().toCharArray();
			int[] arr = new int[strToChar.length];
			int updateCnt = 0;
			for (int i = 0; i < strToChar.length; i++) {
				if (strToChar[i] - '0' != arr[i]) {
					updateCnt++;
					for (int j = i; j < arr.length; j++) {
						arr[j] = strToChar[i] - '0';
					}
				}
			}
			System.out.println("#" + test_case + " " + updateCnt);
		}
	}
}