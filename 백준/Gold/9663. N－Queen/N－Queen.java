import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int totalCount;

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        totalCount = 0;

        boolean[] cols = new boolean[N];  
        // 열 체크
        boolean[] d1 = new boolean[2 * N - 1]; 
        // 주대각선 체크
        boolean[] d2 = new boolean[2 * N - 1]; // 부대각선 체크

        dfs(0, N, cols, d1, d2);
        System.out.print(totalCount);
	}

	static void dfs(int row, int N, boolean[] cols, boolean[] d1, boolean[] d2) {
		if (row == N) {
			totalCount++;
			return;
		}

		for (int col = 0; col < N; col++) {
			int diag1= row - col + N - 1;
			int diag2= row + col;

			if (!cols[col] && !d1[diag1] && !d2[diag2]) {
				// 퀸 배치
				cols[col] = d1[diag1] = d2[diag2] = true;

				// 다음 행으로 재귀 호출
				dfs(row + 1, N, cols, d1, d2);

				// 상태 복원
				cols[col] = d1[diag1] = d2[diag2] = false;
			}
		}
	}
}