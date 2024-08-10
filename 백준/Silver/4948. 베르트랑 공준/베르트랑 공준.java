import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringBuilder sb = new StringBuilder();
		int max = 123456 * 2;
		boolean[] isPrime = new boolean[max + 1];
		// 에라토스테네스의 체 초기화
		for (int i = 2; i <= max; i++) {
			isPrime[i] = true;
		}
		
		// 에라토스테네스의 체 알고리즘
		for (int i = 2; i * i <= max; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= max; j += i) {
					isPrime[j] = false;
				}
			}
		}
		
		while((str = br.readLine()) != null) {
			int N = Integer.parseInt(str);
			if (N == 0) break;
			int cnt = 0;
			for (int num = N + 1; num <= 2 * N; num++) {
				if (isPrime[num]) cnt++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
	}
}