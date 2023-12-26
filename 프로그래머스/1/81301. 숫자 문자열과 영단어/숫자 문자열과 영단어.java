import java.util.HashMap;
class Solution {
    public long solution(String s) {
        HashMap<String, String> map = new HashMap();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        
        for (String str : map.keySet()) {
            if (s.contains(str)) {
                s = s.replace(str, map.get(str));
            }
        }
        int answer = Integer.parseInt(s);
        
        return answer;
    }
}