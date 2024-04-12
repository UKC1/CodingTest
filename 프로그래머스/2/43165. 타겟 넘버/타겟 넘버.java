class Solution {
    int cnt = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return cnt;
    }
    
    public void dfs(int[] numbers, int idx, int sum, int target) {
        if (idx == numbers.length) {
            if (sum == target) {
                cnt++;
            }
            return;
        }
        
        dfs(numbers, idx + 1, sum + numbers[idx], target);
        dfs(numbers, idx + 1, sum - numbers[idx], target);
    }
}