import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		System.out.println(fibonacci(N));
	}

	static int fibonacci(int N) {
		if (N < 2) return N;
		int a = 0;
		int b = 1;
		int c = 0;
		for (int i = 1; i < N; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}
}