import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {   
        int answer = 0;
        
        HashMap<String, Integer> checkMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            checkMap.put(want[i], number[i]);
        }
        
        HashMap<String, Integer> cntMap = new HashMap<>();
     
        // 첫 10일 동안의 상품을 카운트합니다.
        for (int i = 0; i < 10; i++) {
            cntMap.put(discount[i], cntMap.getOrDefault(discount[i], 0) + 1);
        }

        // 11일째부터 마지막 날까지 검사합니다.
        for (int i = 10; i < discount.length; i++) {
            if (isPromotionAvailable(checkMap, cntMap, want)) {
                answer++;
            }
            
            // 10일 전 상품을 제거하고 현재 상품을 추가합니다.
            cntMap.put(discount[i-10], cntMap.getOrDefault(discount[i-10], 0) - 1);
            cntMap.put(discount[i], cntMap.getOrDefault(discount[i], 0) + 1);
        }

        // 마지막 10일 간격 검사
        if (isPromotionAvailable(checkMap, cntMap, want)) {
            answer++;
        }

        return answer;
    }

    // 프로모션 조건을 충족하는지 검사하는 메소드
    private boolean isPromotionAvailable(HashMap<String, Integer> checkMap, HashMap<String, Integer> cntMap, String[] want) {
        for (String s : want) {
            if (cntMap.getOrDefault(s, 0) < checkMap.get(s)) {
                return false;
            }
        }
        return true;
    }
}
