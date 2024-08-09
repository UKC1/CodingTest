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
			String[] strArr = new String[5];
			int totalCnt = 0;
			for (int i = 0; i < 5; i++) {
				strArr[i] = br.readLine();
				totalCnt += strArr[i].length();
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#" + test_case + " ");
			int cnt = 0;
			int idx = 0;
			while (cnt < totalCnt) {
				for (int i = 0; i < strArr.length; i++) {
					if (idx > strArr[i].length() - 1) {
						continue;
					}
					sb.append(strArr[i].charAt(idx));
					cnt++;
				}
				idx++;
			}
			sb.append("\n");
			System.out.print(sb);
		}
	}
}