import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> remainDays = new LinkedList<>();
        ArrayList<Integer> releaseCounts = new ArrayList<>();

        // 각 기능별로 완료되기까지 남은 일수 계산
        for (int i = 0; i < progresses.length; i++) {
            int remainProgress = 100 - progresses[i];
            int day = remainProgress / speeds[i] + (remainProgress % speeds[i] > 0 ? 1 : 0);
            remainDays.offer(day);
        }

        while (!remainDays.isEmpty()) {
            int releaseDay = remainDays.poll();
            int count = 1;

            // 현재 기능보다 먼저 완성되는 기능들을 함께 배포
            while (!remainDays.isEmpty() && remainDays.peek() <= releaseDay) {
                count++;
                remainDays.poll();
            }

            releaseCounts.add(count);
        }

        // 결과를 배열로 변환
        return releaseCounts.stream().mapToInt(i -> i).toArray();
    }
}
