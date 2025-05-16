import java.util.*;

class Solution {
    public int solution(int k, int n, int[][] reqs) {
        List<List<int[]>> typeReqs = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            typeReqs.add(new ArrayList<>());
        }

        for (int[] req : reqs) {
            typeReqs.get(req[2] - 1).add(new int[]{req[0], req[1]});
        }

        int[] result = {Integer.MAX_VALUE};
        generateCombinations(k, n - k, 0, new int[k], typeReqs, result);
        return result[0];
    }

    // 조합 생성 (n-k개를 k개 자리에 0 이상 분배)
    private void generateCombinations(int k, int remain, int idx, int[] dist, List<List<int[]>> typeReqs, int[] result) {
        if (idx == k) {
            if (remain == 0) {
                // dist[i]는 추가 멘토 수 → 기본 1명 포함
                int[] mentorsPerType = new int[k];
                for (int i = 0; i < k; i++) {
                    mentorsPerType[i] = dist[i] + 1;
                }
                int totalWait = simulate(mentorsPerType, typeReqs);
                result[0] = Math.min(result[0], totalWait);
            }
            return;
        }

        for (int i = 0; i <= remain; i++) {
            dist[idx] = i;
            generateCombinations(k, remain - i, idx + 1, dist, typeReqs, result);
        }
    }

    // 정확한 시뮬레이션
    private int simulate(int[] mentorsPerType, List<List<int[]>> typeReqs) {
        int totalWait = 0;

        for (int type = 0; type < mentorsPerType.length; type++) {
            int mentorCount = mentorsPerType[type];
            List<int[]> requests = typeReqs.get(type);
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int[] req : requests) {
                int start = req[0];
                int duration = req[1];

                // 상담 끝난 멘토 정리
                while (!pq.isEmpty() && pq.peek() <= start) {
                    pq.poll();
                }

                if (pq.size() < mentorCount) {
                    // 바로 상담 가능
                    pq.offer(start + duration);
                } else {
                    // 대기 발생
                    int earliestEnd = pq.poll();
                    totalWait += earliestEnd - start;
                    pq.offer(earliestEnd + duration);
                }
            }
        }

        return totalWait;
    }
}
