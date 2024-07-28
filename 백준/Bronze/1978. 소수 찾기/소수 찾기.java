import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (isPrime(num)) {
				cnt++;
			}
		}
		System.out.println(cnt);

	}

	public static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}

		if (num == 2 || num == 3) {
			return true;
		}

		if (num % 2 == 0 || num % 3 == 0) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(num); i ++) {
			if (i % 6 == 1 || i % 6 == 5) {
				if (num % i == 0 || num % (i + 2) == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
