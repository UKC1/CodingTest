import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int M = Integer.parseInt(str);
		str = br.readLine();
		int N = Integer.parseInt(str);

		int min = 0;
		int sum = 0;
		for (int i = M; i <= N; i++) {
			if (isPrime(i)) {
				if (min == 0) {
					min = i;
				}
				sum += i;
			}
		}
		if (min == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
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

		for (int i = 5; i * i <= num; i+=6) {
			if (num % i == 0 || num % (i + 2) == 0) {
				return false;
			}
		}
		return true;
	}
}
