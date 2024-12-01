class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int len = 2 * w + 1;  // 하나의 기지국이 커버할 수 있는 길이
        int current = 1;      // 현재 탐색 위치 (1부터 시작)

        for (int station : stations) {
            int coverageStart = Math.max(station - w, 1);  // 현재 기지국의 시작 범위
            int coverageEnd = Math.min(station + w, n);    // 현재 기지국의 끝 범위

            if (current < coverageStart) {
                int uncoveredLength = coverageStart - current;  // 커버되지 않은 구간 길이
                answer += Math.ceil((double) uncoveredLength / len);  // 필요한 기지국 개수 추가
            }
            current = coverageEnd + 1;  // 다음 탐색 위치 갱신
        }

        // 마지막 기지국 이후로 커버되지 않은 구간 처리
        if (current <= n) {
            int remainingLength = n - current + 1;
            answer += Math.ceil((double) remainingLength / len);
        }

        return answer;
    }
}
