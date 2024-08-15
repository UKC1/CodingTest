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
		Set<String> set = new HashSet<>();
		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String firstPerson = st.nextToken();
			String secondPerson = st.nextToken();
			if (firstPerson.equals("ChongChong") || secondPerson.equals("ChongChong")) {
				set.add(firstPerson);
				set.add(secondPerson);
			} else {
				if (set.contains(firstPerson) || set.contains(secondPerson)) {
					set.add(firstPerson);
					set.add(secondPerson);
				}
			}
		}
		System.out.print(set.size());
	}
}