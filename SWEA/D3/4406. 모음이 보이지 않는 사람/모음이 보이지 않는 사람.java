import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		String[] aeiou = {"a", "e", "i", "o", "u"};
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = br.readLine();
			for (int i = 0; i < aeiou.length; i++) {
				str = str.replace(aeiou[i], "");
			}
			System.out.println("#" + test_case + " " + str);
		}
	}
}