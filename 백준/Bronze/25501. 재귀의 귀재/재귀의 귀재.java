import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			char[] s = br.readLine().toCharArray();
			sb.append(isPalindrome(s)).append(" ");
			sb.append(cnt).append("\n");
			cnt = 0;
		}
		System.out.print(sb);
	}
	static int recursion(char[] s, int l, int r) {
		cnt++;
		if (l >= r) return 1;
		else if (s[l] != s[r]) return 0;
		else return recursion(s, l + 1, r - 1);
	}

	static int isPalindrome(char[] s) {
		return recursion(s, 0, s.length - 1);
	}
}