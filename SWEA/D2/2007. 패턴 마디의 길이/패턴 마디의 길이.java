import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			int minLen = 30;
			int newLen = 0;
			for (int j = 0; j < 10; j++) {
				String newStr = str.substring(0, j + 1);
				int strLen = str.replace(newStr, "").length();
				if (minLen > strLen) {
					minLen = strLen;
					newLen = newStr.length();
				}
			}
			System.out.println("#" + i + " " + newLen);
		}
	}
}