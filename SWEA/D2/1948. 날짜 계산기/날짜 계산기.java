import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int firstMonth = Integer.parseInt(st.nextToken());
			int firstDay = Integer.parseInt(st.nextToken());
			int secondMonth = Integer.parseInt(st.nextToken());
			int secondDay = Integer.parseInt(st.nextToken());
			int firstConvertDays = firstDay;
			for (int i = 1; i < firstMonth; i++) {
				firstConvertDays += days[i];
			}

			int secondConvertDays = secondDay;
			for (int i = 1; i < secondMonth; i++) {
				secondConvertDays += days[i];
			}

			System.out.println("#" + test_case + " " + (secondConvertDays - firstConvertDays + 1));
		}
	}
}