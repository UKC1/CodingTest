import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 1; test_case <= 10; test_case++) {
            int T = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxRowSum = 0;
            int maxColSum = 0;
            int leftDiagonalSum = 0;
            int rightDiagonalSum = 0;
            for (int i = 0; i < 100; i++) {
                int rowSum = 0;
                int colSum = 0;
                for (int j = 0; j < 100; j++) {
                    rowSum += arr[i][j];
                    colSum += arr[j][i];
                }
                leftDiagonalSum += arr[i][i];
                rightDiagonalSum += arr[i][99 - i];
                if (maxRowSum < rowSum) maxRowSum = rowSum;
                if (maxColSum < colSum) maxColSum = colSum;
            }

            int maxSum = maxColSum > maxRowSum ? maxColSum : maxRowSum;
            int maxDiagonalSum = leftDiagonalSum > rightDiagonalSum ? leftDiagonalSum : rightDiagonalSum;
            maxSum = maxSum > maxDiagonalSum ? maxSum : maxDiagonalSum;

            System.out.println("#" + test_case + " " + maxSum);
        }
    }
}