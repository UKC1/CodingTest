import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int max = 1000000;
		boolean[] isPirme = new boolean[max + 1];
		for (int i = 2; i <= max; i++) {
			isPirme[i] = true;
		}

		for (int i = 2; i * i <= max; i++) {
			if (isPirme[i]) {
				for (int j = i * i; j <= max; j+=i) {
					isPirme[j] = false;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(goldBach(num, isPirme)).append("\n");
		}
		System.out.print(sb);
	}

	static int goldBach(int num, boolean[] isPrime) {
		int cnt = 0;
		for (int i = 2; i <= num / 2; i++) {
			if (isPrime[i] && isPrime[num - i]) {
				cnt++;
			}
		}
		return cnt;
	}
}