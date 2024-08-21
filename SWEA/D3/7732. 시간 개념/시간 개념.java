import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] currentTime = br.readLine().split(":");
			int currentHour = Integer.parseInt(currentTime[0]);
			int currentMin = Integer.parseInt(currentTime[1]);
			int currentSec = Integer.parseInt(currentTime[2]);
			String[] promiseTime = br.readLine().split(":");
			int promiseHour = Integer.parseInt(promiseTime[0]);
			int promiseMin = Integer.parseInt(promiseTime[1]);
			int promiseSec = Integer.parseInt(promiseTime[2]);

			int resultHour = promiseHour - currentHour;
			int resultMin = promiseMin - currentMin;
			int resultSec = promiseSec - currentSec;
			if (resultSec < 0) {
				resultSec += 60;
				resultMin -= 1;
			}

			if (resultMin < 0) {
				resultMin += 60;
				resultHour--;
			}

			if (resultHour < 0) {
				resultHour += 24;
			}

			sb.append("#").append(test_case).append(" ")
				.append(resultHour > 9 ? resultHour : "0" + resultHour).append(":")
				.append(resultMin > 9 ? resultMin : "0" + resultMin).append(":")
				.append(resultSec > 9 ? resultSec : "0" + resultSec).append("\n");
		}
		System.out.print(sb);
	}
}