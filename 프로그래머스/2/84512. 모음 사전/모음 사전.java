import java.util.*;

class Solution {
    public int solution(String word) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('E', 2);
        map.put('I', 3);
        map.put('O', 4);
        map.put('U', 5);
        int sum = 0;
        int[] values = {781, 156, 31, 6, 1};
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int value = (map.get(c) - 1) * values[i];
            sum += value;
        }
        sum += word.length();
        return sum;
    }
}