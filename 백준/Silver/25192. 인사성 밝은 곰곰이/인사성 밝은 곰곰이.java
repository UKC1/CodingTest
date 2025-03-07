import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Set<String> set = new HashSet<>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (!str.equals("ENTER")) {
				set.add(str);
			} else {
				cnt += set.size();
				set.clear();
			}
		}
		cnt += set.size();
		System.out.print(cnt);
	}
}