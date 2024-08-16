import java.util.*;
class Solution {
    public int solution(String word) {
        Map<Character, Integer> map = new HashMap<>();
        int[] num = {781, 156, 31, 6, 1};
        int answer = 0;
        map.put('A', 1);
        map.put('E', 2);
        map.put('I', 3);
        map.put('O', 4);
        map.put('U', 5);
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int value = map.get(c);
            answer += (value - 1) * num[i];
        }
        answer += word.length();
        
        
        return answer;
    }
}