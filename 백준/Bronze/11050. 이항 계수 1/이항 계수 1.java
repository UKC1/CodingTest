import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		System.out.println(factorial(N) / factorial(N - K) / factorial(K)) ;
	}

	static int factorial(int num) {
		if (num == 0) return 1;
		int mul = 1;
		for (int i = 1; i <= num; i++) {
			mul *= i;
		}
		return mul;
	}
}