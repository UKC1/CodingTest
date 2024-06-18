import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        Set<Integer> set = new HashSet();
        boolean[] visited = new boolean[numbers.length()];
        dfs("", numbers.toCharArray(), visited, set);
        for (Integer num : set) {
            if (isPrime(num)) answer++;
        }
        return answer;
    }
    
    public void dfs(String current, char[] numArr, boolean[] visited, Set<Integer> set) {
        if (!current.isEmpty()) {
            set.add(Integer.parseInt(current));
        }
        
        for (int i = 0; i < numArr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(current + numArr[i], numArr, visited, set);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } 
        if (n == 2 || n == 3) {
            return true;
        }
        
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        
        for (int i = 5; i <= Math.sqrt(n); i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        
        return true;
    }
}