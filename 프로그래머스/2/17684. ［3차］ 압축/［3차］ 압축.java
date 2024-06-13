import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < 26; i++) {
            map.put(Character.toString((char)i+'A'), i + 1);
            
        } 
        List<Integer> output = new ArrayList();
        int idx = 0;
        int endIdx = 27;
        int length = 2;
        
        while(idx + length <= msg.length()) {
            String w = msg.substring(idx, idx + length);
            if (idx + length <= msg.length() && !map.containsKey(w)) {
                output.add(map.get(msg.substring(idx, idx + length - 1)));
                map.put(w, endIdx++);
                idx += w.length() - 1;
                length = 2;
            } else {
                length++;
            }
        }
        output.add(map.get(msg.substring(idx, idx + length - 1)));
        return output.stream().mapToInt(i->i).toArray();
    }
}