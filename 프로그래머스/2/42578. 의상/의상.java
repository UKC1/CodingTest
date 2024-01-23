import java.util.HashMap;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int sum = 0;
        int mul = 1;
        for (String s : map.keySet()) {
            mul *= (map.get(s) + 1);
        }
        System.out.println(map);
        // 3C1 + 3C2 + 3C3 - 2C1;
        
        return mul - 1;
    }
}