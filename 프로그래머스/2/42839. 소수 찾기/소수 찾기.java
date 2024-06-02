import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        boolean[] visited = new boolean[numbers.length()];
        Set<Integer> nums = new HashSet();
        dfs("", numbers.toCharArray(), visited, nums);
        for (Integer num : nums) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(String current, char[] numArray, boolean[] visited, Set<Integer> nums) {
        if (!current.isEmpty()) {
            nums.add(Integer.parseInt(current));
        }
        
        for (int i = 0; i < numArray.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(current + numArray[i], numArray, visited, nums);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } else if (n == 2 || n == 3) {
            return true;
        }
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}