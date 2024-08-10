import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringBuilder sb = new StringBuilder();
		while((str = br.readLine()) != null) {
			int N = Integer.parseInt(str);
			if (N == 0) break;
			int cnt = 0;
			for (int num = N + 1; num <= 2 * N; num++) {
				if (isPrime(num)) cnt++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
	}

	public static boolean isPrime(int num) {
		if (num < 2) return false;
		if (num == 2 || num == 3) return true;
		if (num % 2 == 0 || num % 3 == 0) return false;
		for (int i = 5; i * i <= num; i++) {
			if (num % i == 0 || num % (i + 2) == 0) return false;
		}
		return true;
	}
}