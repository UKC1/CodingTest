class Solution {
    int num = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers, 0, 0, target);
        return num;
    }
    
    public void dfs(int[] numbers, int sum, int idx, int target) {
        if (numbers.length == idx) {
            if (sum == target) {
                num++;
            }
            return;
        }
    
        dfs(numbers, sum + numbers[idx], idx + 1, target);
        dfs(numbers, sum - numbers[idx], idx + 1, target); 
    }
}