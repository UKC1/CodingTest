import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class StrToken {
		String str;
		public StrToken(String str) {
			this.str = str;
		}

		public String getStr() {
			return str;
		}

		public int getLen() {
			return str.length();
		}

		public int getSum() {
			int sum = 0;
			char[] arr = str.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] >= '0' && arr[i] <= '9') {
					sum += arr[i] - '0';
				}
			}
			return sum;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		List<StrToken> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(new StrToken(br.readLine()));
		}

		list.sort(Comparator.comparing(StrToken::getLen)
			.thenComparing(StrToken::getSum)
			.thenComparing(StrToken::getStr));

		for (StrToken str : list) {
			System.out.println(str.getStr());
		}
	}
}