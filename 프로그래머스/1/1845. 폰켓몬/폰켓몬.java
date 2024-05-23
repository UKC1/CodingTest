import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> uniquePokemon = new HashSet();
        for (Integer num : nums) {
            uniquePokemon.add(num);
        }
        
        return Math.min(uniquePokemon.size(), nums.length / 2);
    }
}