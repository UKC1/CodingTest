import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        int i = 0;
        for (; i < enemy.length; i++) {
            maxHeap.offer(enemy[i]);
            n -= enemy[i];

            if (n < 0) {
                if (k > 0) {
                    n += maxHeap.poll(); // 가장 큰 값을 무적권으로 되돌림
                    k--;
                } else {
                    break; // 무적권도 없고 병사도 부족하면 종료
                }
            }
        }
        return i; // 버틴 라운드 수
    }
}
