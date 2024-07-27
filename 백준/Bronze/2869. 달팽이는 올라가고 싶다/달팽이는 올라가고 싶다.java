import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int upLen = Integer.parseInt(st.nextToken());
		int downLen = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int day = (height - upLen) % (upLen - downLen) == 0 ? (height - upLen) / (upLen - downLen) + 1: (height - upLen) / (upLen - downLen) + 2;
		System.out.print(day);
	}
}
