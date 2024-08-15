import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			System.out.println(combination(M, N));
		}
	}

	static int combination(int N, int K) {
		if (N - K < K) K = N - K;
		int mul = 1;
		for (int i = 0; i < K; i++) {
			mul *= N--;
			mul /= (i + 1);
		}
		return mul;
	}
}