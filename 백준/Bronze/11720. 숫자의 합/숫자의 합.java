import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		char[] chars = br.readLine().toCharArray();
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += chars[i] - '0';
		}
		System.out.print(sum);
    }
}

