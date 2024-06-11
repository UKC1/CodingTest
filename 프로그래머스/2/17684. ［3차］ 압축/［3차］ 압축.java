import java.util.*;
class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < 26; i++) {
            map.put(Character.toString((char) (i + 'A')), i + 1);
        }
        
        // 추가된 제일 긴 단어까지 찾음
        
        List<Integer> list = new ArrayList();
        int len = 0;
        int idx = 1;
        String w = msg.substring(0, 1);
        String c;
        while(len <= msg.length() && idx < msg.length()) {
            c = msg.substring(idx, idx + 1);
            if (map.get(w+c) == null) {
                map.put(w+c, map.size() + 1);
                list.add(map.get(w));
                w = c;
                idx++;
                len += w.length();
            } else {
                w += c;
                idx++;
            }
            // System.out.print(w + " " + c + " / ");
            
        }
        list.add(map.get(w));
        int[] answer = new int[list.size()];
        for (int i = 0 ; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}