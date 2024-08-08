import java.util.*;

class Solution {
    public int solution(String numbers) {
        char[] arr = numbers.toCharArray();
        boolean[] visited = new boolean[arr.length];
        Set<Integer> set = new HashSet<>();
        dfs("", arr, visited, set);
        int cnt = 0;
        for (int num : set) {
            if (isPrime(num)) cnt++; 
        }
        return cnt;
    }
    // 완전 탐색을 위한 메서드
    public void dfs(String current, char[] arr, boolean[] visited, Set<Integer> set) {
        if (!current.equals("")) {
            set.add(Integer.parseInt(current));    
        }
        for (int i = 0; i < arr.length; i++){ 
            if (!visited[i]) {
                visited[i] = true;
                dfs(current + arr[i], arr, visited, set);
                visited[i] = false;
            }
        }
    }
    
    // 소수 찾기 메서드
    public boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        // 6k + 1, 6k + 5 (6k, 6k + 2, 6k + 3, 6k + 4 형태는 앞의 2, 3배수로 처리됨)
        // 6k + 5, 6k + 7만 체크
        for (int i = 5; i * i <= n; i+=6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}