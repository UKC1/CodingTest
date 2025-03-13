import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int n = gems.length;

        // 1. 보석 종류 개수 확인
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        int totalTypes = gemTypes.size();

        // 2. 투 포인터 + 해시맵 활용
        Map<String, Integer> gemCount = new HashMap<>();
        int start = 0, end = 0, minLength = Integer.MAX_VALUE;

        while (end < n) {
            // 현재 보석 추가
            gemCount.put(gems[end], gemCount.getOrDefault(gems[end], 0) + 1);
            end++;

            // 모든 보석을 포함하는지 확인
            while (gemCount.size() == totalTypes) {
                // 최소 구간 갱신
                if (end - start < minLength) {
                    minLength = end - start;
                    answer[0] = start + 1;  // 1-based index
                    answer[1] = end;
                }

                // start 보석 제거 및 이동
                gemCount.put(gems[start], gemCount.get(gems[start]) - 1);
                if (gemCount.get(gems[start]) == 0) {
                    gemCount.remove(gems[start]);
                }
                start++;
            }
        }

        return answer;
    }
}
