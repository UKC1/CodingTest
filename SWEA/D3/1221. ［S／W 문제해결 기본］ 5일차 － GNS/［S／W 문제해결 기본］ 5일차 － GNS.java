import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	static class Number {
		String Name;
		int value;
		Number(String Name, int value) {
			this.Name = Name;
			this.value = value;
		}

		public String getName() {
			return Name;
		}

		public int getValue() {
			return value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			Map<String, Integer> map = new HashMap<>();
			map.put("ZRO", 0);
			map.put("ONE", 1);
			map.put("TWO", 2);
			map.put("THR", 3);
			map.put("FOR", 4);
			map.put("FIV", 5);
			map.put("SIX", 6);
			map.put("SVN", 7);
			map.put("EGT", 8);
			map.put("NIN", 9);
			List<Number> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				String name = st.nextToken();
				int value = map.get(name);
				list.add(new Number(name, value));
			}
			list.sort(Comparator.comparingInt(Number::getValue));
			sb.append("#").append(test_case).append("\n");
			for (Number number : list) {
				sb.append(number.getName()).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}