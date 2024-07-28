import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while((str = br.readLine()) != null && !str.equals("0 0")) {
			int firstNum = Integer.parseInt(str.split(" ")[0]);
			int secondNum = Integer.parseInt(str.split(" ")[1]);
			if (secondNum % firstNum == 0) {
				System.out.println("factor");
			} else if (firstNum % secondNum == 0) {
				System.out.println("multiple");
			} else {
				System.out.println("neither");
			}
		}
	}
}
