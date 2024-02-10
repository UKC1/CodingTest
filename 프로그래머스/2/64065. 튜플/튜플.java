import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(String s) {
        String[] sets = s.substring(1, s.length() - 1).replaceAll("[{}]", " ").split(" , ");
        Arrays.sort(sets, Comparator.comparingInt(String::length));
        
        Set<Integer> set = new HashSet<>();
        int[] answer = new int[sets.length];
        int idx = 0;

        for (String strSet : sets) {
            for (String numStr : strSet.split(",")) {
                int num = Integer.parseInt(numStr.trim());
                if (set.add(num)) {
                    answer[idx++] = num;
                }
            }
        }

        return answer;
    }
}
