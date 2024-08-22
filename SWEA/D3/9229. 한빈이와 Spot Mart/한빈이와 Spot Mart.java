import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
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

            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < weights.length; i++) {
                for (int j = i + 1; j < weights.length; j++) {
                    int weight = weights[i] + weights[j];
                    if (weight <= weightLimit) {
                        pq.offer(weight);
                    }
                }
            }
            sb.append("#").append(test_case).append(" ").append(pq.isEmpty() ? -1 : pq.poll()).append("\n");
        }
        System.out.print(sb);
    }

}