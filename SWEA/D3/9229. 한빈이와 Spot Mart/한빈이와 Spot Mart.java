import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int weightLimit = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] weights = new int[N];
            for (int i = 0; i < N; i++) {
                weights[i] = Integer.parseInt(st.nextToken());
            }

            // 배열 정렬
            Arrays.sort(weights);

            int maxWeight = -1;
            int left = 0;
            int right = N - 1;

            while (left < right) {
                int weight = weights[left] + weights[right];
                
                if (weight <= weightLimit) {
                    maxWeight = Math.max(maxWeight, weight);
                    left++; // 더 큰 합을 찾기 위해 왼쪽 포인터를 증가시킴
                } else {
                    right--; // 제한을 넘지 않도록 하기 위해 오른쪽 포인터를 감소시킴
                }
            }

            sb.append("#").append(test_case).append(" ").append(maxWeight).append("\n");
        }
        System.out.print(sb);
    }
}