import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] numToStr = new String[numbers.length];
        for (int i = 0; i < numToStr.length; i++) {
            numToStr[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(numToStr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        StringBuilder sb = new StringBuilder();
        for (String str : numToStr) {
            sb.append(str);
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}