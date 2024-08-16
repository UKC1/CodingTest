import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		Map<Character, Integer> map = new TreeMap<>();
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			for (char c : br.readLine().toCharArray()) {
				map.put(c, map.getOrDefault(c,0) + 1);
			}

			sb.append("#").append(test_case).append(" ");
			boolean isGood = true;
			for (char c : map.keySet()) {
				if (map.get(c) % 2 == 1) {
					sb.append(c);
					isGood = false;
				}
			}

			if (isGood) sb.append("Good");
			sb.append("\n");
			map.clear();
		}
		System.out.print(sb);
	}
}