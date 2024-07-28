import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while ((str = br.readLine()) != null && !str.equals("-1")) {
			int N = Integer.parseInt(str);
			List<Integer> list = new ArrayList<>();
			int sum = 0;
			for (int i = 1; i < N; i++) {
				if (N % i == 0) {
					list.add(i);
					sum += i;
				}
			}

			if (sum == N) {
				System.out.print(N + " = " );
				for (int i = 0; i < list.size(); i++) {
					if (i == list.size() - 1) {
						System.out.print(list.get(i));
					} else {
						System.out.print(list.get(i) + " + ");
					}
				}
				System.out.println();
			} else {
				System.out.println(N + " is NOT perfect.");
			}

		}
	}
}
