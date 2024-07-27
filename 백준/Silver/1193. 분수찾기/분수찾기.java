import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int cnt = 0;
		loop : for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i + 1 ; j++) {
				if (j < i + 1) {
					cnt++;
				}
				if (cnt == N) {
					if ((i + 1) % 2 != 0) {
						System.out.print(j + "/" + (i + 1 - j));
					} else {
						System.out.print((i + 1 - j) + "/" + j);
					}
					break loop;
				}
			}
		}
	}
}
