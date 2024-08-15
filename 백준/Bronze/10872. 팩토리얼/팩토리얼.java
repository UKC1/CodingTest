import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		System.out.print(permutation(N));

	}

	static int permutation(int N) {
		if(N == 0) return 1;
		int mul = 1;
		for (int i = 1; i <= N; i++) {
			mul *= i;
		}
		return mul;
	}
}