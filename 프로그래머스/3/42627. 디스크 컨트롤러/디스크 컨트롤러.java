import java.util.*;

class Solution {
    class Process {
        int start;
        int length;
        Process(int start, int length) {
            this.start = start;
            this.length = length;
        }
    }

    public int solution(int[][] jobs) {
        // 작업을 도착 시간 기준으로 정렬
        Arrays.sort(jobs, (j1, j2) -> Integer.compare(j1[0], j2[0]));
        
        // 작업이 짧은 애를 넣자
        PriorityQueue<Process> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.length));
        int time = 0;
        int totalProcessTime = 0;
        int index = 0;
        int jobCount = jobs.length;

        while (index < jobCount || !pq.isEmpty()) {
            // 현재 시간까지 도착한 모든 작업을 큐에 넣는다.
            while (index < jobCount && jobs[index][0] <= time) {
                pq.offer(new Process(jobs[index][0], jobs[index][1]));
                index++;
            }

            // 큐가 비어 있으면 다음 작업의 시작 시간으로 시간을 이동
            if (pq.isEmpty()) {
                time = jobs[index][0];
            } else {
                // 큐에서 가장 짧은 작업을 꺼내 처리
                Process process = pq.poll();
                time += process.length;
                totalProcessTime += time - process.start;
            }
        }
        
        return totalProcessTime / jobCount;
    }
}
