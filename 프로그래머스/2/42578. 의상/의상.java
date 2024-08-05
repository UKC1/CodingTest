import java.util.HashMap;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int totalCombination = 1;
        for (Integer num : map.values()) {
            totalCombination *= (num + 1);
        }
    
        return totalCombination - 1;
    }
}