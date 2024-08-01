import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] firstArr = new int[N];
            int[] secondArr = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                firstArr[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                secondArr[i] = Integer.parseInt(st.nextToken());
            }

            int maxSum = 0;
            if (firstArr.length > secondArr.length) {
                for (int i = 0; i <= firstArr.length - secondArr.length; i++) {
                    int arrSum = 0;
                    for (int j = i; j < secondArr.length + i; j++) {
                        arrSum += firstArr[j] * secondArr[j - i];
                    }
                    if (maxSum < arrSum) maxSum = arrSum;
                }
            } else {
                for (int i = 0; i <= secondArr.length - firstArr.length; i++) {
                    int arrSum = 0;
                    for (int j = i; j < firstArr.length + i; j++) {
                        arrSum += firstArr[j - i] * secondArr[j];
                    }
                    if (maxSum < arrSum) maxSum = arrSum;
                }
            }
            System.out.println("#" + test_case + " " + maxSum);

        }
    }
}