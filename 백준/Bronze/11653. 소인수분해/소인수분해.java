import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str);
		if (isPrime(N)) {
			System.out.println(N);
		} else {
			for (int i = 2; i <= N; i++) {
				if (N % i == 0 && isPrime(i)) {
					while(N % i == 0) {
						N /= i;
						System.out.println(i);
					}
				}

				if (N == 1) {
					break;
				}
			}
		}
	}

	public static boolean isPrime(int N) {
		if (N == 1) {
			return false;
		}

		if (N == 2 || N == 3) {
			return true;
		}

		if (N % 2 == 0 || N % 3 == 0) {
			return false;
		}

		for (int i = 5; i * i <= N; i+=6) {
			if(N % i == 0 || N % (i + 2) == 0) {
				return false;
			}
		}
		return true;
	}

}
