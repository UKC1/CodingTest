import java.util.*;
class Solution {
    public int solution(String numbers) {
        int answer = 0;
        Set<Integer> set = new HashSet();
        boolean[] visited = new boolean[numbers.length()];
        dfs("", numbers.toCharArray(), set, visited, 0);
        for (Integer num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(String current, char[] numbers, Set<Integer> set, boolean[] visited, int start){
        
        if (!current.isEmpty()){
            set.add(Integer.parseInt(current));  
        }
                
        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(current + numbers[i], numbers, set, visited, i);       
                visited[i] = false;
            }       
               
        }
    }
    
    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2 || n == 3) {
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