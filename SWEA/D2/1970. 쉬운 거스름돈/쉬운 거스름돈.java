import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] changeMoney = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		int[] cntMoney = new int[changeMoney.length];
		for (int test_case = 1; test_case <= T; test_case++) {
			int money = Integer.parseInt(br.readLine());
			for (int i = 0; i < changeMoney.length; i++) {
				cntMoney[i] = money / changeMoney[i];
				money = money % changeMoney[i];
			}

			System.out.println("#" + test_case);
			for (int change : cntMoney) {
				System.out.print(change + " ");
			}
			System.out.println();
		}
		br.close();
	}
}