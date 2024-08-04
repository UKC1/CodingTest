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
			int updateCnt = strToChar[0] == '1' ? 1 : 0;
			for (int i = 0; i < strToChar.length - 1; i++) {
				if (strToChar[i] != strToChar[i + 1]) {
					updateCnt++;
				}
			}
			System.out.println("#" + test_case + " " + updateCnt);
		}
	}
}