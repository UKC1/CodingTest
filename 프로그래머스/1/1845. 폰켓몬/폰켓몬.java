import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet();
        for (Integer i : nums) {
            set.add(i);
        }
        
        return Math.min(set.size(), nums.length / 2);
    }
}