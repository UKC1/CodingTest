import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 보석과 가방을 통합한 리스트
        List<int[]> items = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            items.add(new int[]{weight, value}); // 보석
        }

        for (int i = 0; i < K; i++) {
            int bagWeight = Integer.parseInt(br.readLine());
            items.add(new int[]{bagWeight, -1}); // 가방
        }

        // 무게 기준 오름차순 정렬, 무게가 같으면 가방 우선
        items.sort((a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));

        // 가치 기준 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(N, Comparator.reverseOrder());
        long totalValue = 0;

        for (int[] item : items) {
            if (item[1] == -1) { // 가방
                if (!pq.isEmpty()) {
                    totalValue += pq.poll(); // 가장 가치 높은 보석 선택
                }
            } else { // 보석
                pq.offer(item[1]); // 우선순위 큐에 가치 추가
            }
        }

        System.out.println(totalValue);
    }
}