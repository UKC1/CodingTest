import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] minus = br.readLine().split("-");
		int minSum = 0;
		for (int i = 0; i < minus.length; i++) {
			int minusSum = 0;
			if (minus[i].contains("+")) {
				String[] plus = minus[i].replace("+", " ").split(" ");
				for (int j = 0; j < plus.length; j++) {
					minusSum += Integer.parseInt(plus[j]);
				}
			} else {
				minusSum += Integer.parseInt(minus[i]);
			}
			
			if (i == 0) minSum += minusSum;
			else minSum -= minusSum;
		}
		System.out.print(minSum);
	}
}