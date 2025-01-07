import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        // 숫자별 빈도를 저장하기 위한 Map
        Map<Integer, Long> weightMap = new HashMap<>();
        for (int weight : weights) {
            weightMap.put(weight, weightMap.getOrDefault(weight, 0L) + 1);
        }

        // 숫자 배열 정렬 (중복 제거를 위해 Set 사용)
        Set<Integer> uniqueWeights = new HashSet<>();
        for (int weight : weights) {
            uniqueWeights.add(weight);
        }

        // 비율 계산
        for (int weight : uniqueWeights) {
            long count = weightMap.get(weight);

            // 1:1 비율
            answer += count * (count - 1) / 2;

            // 2:3 비율
            if (weight % 2 == 0 && weightMap.containsKey(weight / 2 * 3)) {
                answer += count * weightMap.get(weight / 2 * 3);
            }

            // 3:4 비율
            if (weight % 3 == 0 && weightMap.containsKey(weight / 3 * 4)) {
                answer += count * weightMap.get(weight / 3 * 4);
            }

            // 1:2 비율
            if (weightMap.containsKey(weight * 2)) {
                answer += count * weightMap.get(weight * 2);
            }
        }

        return answer;
    }
}
