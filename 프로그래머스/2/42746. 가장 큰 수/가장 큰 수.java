import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] numToStr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numToStr[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(numToStr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        // System.out.println(Arrays.toString(numToStr));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numToStr.length; i++) {
            sb.append(numToStr[i]);
        }
        
        if (sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}