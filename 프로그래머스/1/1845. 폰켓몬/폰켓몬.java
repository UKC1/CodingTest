import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet();
        for (Integer i : nums) {
            set.add(i);
        }
        
        int answer = nums.length / 2;
        
        if (set.size() < nums.length / 2) {
            answer = set.size();
        }
        
        return answer;
    }
}