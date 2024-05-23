import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap();
        for (String runner : participant) {
            map.put(runner, map.getOrDefault(runner, 0) + 1);
        }
        
        for (String runner : completion) {
            map.put(runner, map.get(runner) - 1);
        }
        
        for (String runner : map.keySet()) {
            if (map.get(runner) > 0) {
                return runner;
            }
        }
        return "";
    }
}