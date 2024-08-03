import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int startHour = Integer.parseInt(st.nextToken());
			int startMin = Integer.parseInt(st.nextToken());
			int endHour = Integer.parseInt(st.nextToken());
			int endMin = Integer.parseInt(st.nextToken());

			int sumHour = startHour + endHour;
			int sumMin = startMin + endMin;
			int totalMin = sumHour * 60 + sumMin;
			int hour = (totalMin / 60) % 25;
			if (hour > 12) {
				hour -= 12;
			}
			int min = totalMin % 60;

			System.out.println("#" + test_case + " " + hour + " " + min);

		}
	}
}