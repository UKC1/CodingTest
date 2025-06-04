import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            int M = Integer.parseInt(br.readLine());
            int count = 0;

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 작은 값
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 큰 값

            StringBuilder sb = new StringBuilder();
            sb.append((M + 1) / 2).append("\n"); // 중앙값 개수 먼저 출력

            int printed = 0;
            while (count < M) {
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    int num = Integer.parseInt(st.nextToken());

                    if (maxHeap.size() == minHeap.size()) {
                        maxHeap.offer(num);
                    } else {
                        minHeap.offer(num);
                    }

                    if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                        int a = maxHeap.poll();
                        int b = minHeap.poll();
                        maxHeap.offer(b);
                        minHeap.offer(a);
                    }

                    if (count % 2 == 0) {
                        sb.append(maxHeap.peek()).append(" ");
                        printed++;
                        if (printed % 10 == 0) sb.append("\n");
                    }
                    count++;
                }
            }
            if (printed % 10 != 0) sb.append("\n");
            System.out.print(sb);

        }
    }
}
