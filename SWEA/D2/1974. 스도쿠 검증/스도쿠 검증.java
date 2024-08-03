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
			int[][] arr = new int[9][9];
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			if (rowCheck(arr) && colCheck(arr) && squareCheck(arr)) {
				System.out.println("#" + test_case + " " + 1);
			} else {
				System.out.println("#" + test_case + " " + 0);
			}
		}
	}

	public static boolean rowCheck(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			int[] checkArr = new int[10];
			for (int j = 0; j < arr[i].length; j++) {
				checkArr[arr[i][j]]++;
			}

			for (int j = 1; j < 10; j++) {
				if (checkArr[j] != 1) return false;
			}
		}
		return true;
	}

	public static boolean colCheck(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			int[] checkArr = new int[10];
			for (int j = 0; j < arr.length; j++) {
				checkArr[arr[j][i]]++;
			}

			for (int j = 1; j < 10; j++) {
				if (checkArr[j] != 1) return false;
			}
		}
		return true;
	}

	public static boolean squareCheck(int[][] arr) {
		int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
		int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

		for (int i = 1; i < arr.length; i+=3) {
			for (int j = 1; j < arr.length; j+=3) {
				int[] checkArr = new int[10];
				for (int k = 0; k < 9; k++) {
					int row = i + dx[k];
					int col = j + dy[k];
					checkArr[arr[row][col]]++;
				}

				for (int k = 1; k < 10; k++) {
					if (checkArr[k] != 1) return false;
				}
			}
		}
		return true;
	}
}