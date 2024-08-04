import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			int K = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int totalGames = (int)Math.pow(2, K);

			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < totalGames; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			int totalScore = 0;
			while (list.size() > 1) {
				List<Integer> temp = new ArrayList<>();
				for (int i = 0; i < list.size(); i+=2) {
					if (list.get(i) < list.get(i+1)) {
						totalScore += list.get(i+1) - list.get(i);
						temp.add(list.get(i + 1));
					} else {
						totalScore += list.get(i) - list.get(i+1);
						temp.add(list.get(i));
					}
				}
				list = temp;
			}
			System.out.println("#" + test_case + " " + totalScore);
		}
	}
}