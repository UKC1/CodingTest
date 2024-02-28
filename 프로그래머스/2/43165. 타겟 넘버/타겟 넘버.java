class Solution {
    int count;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return count;
    }
    
    public void dfs(int[] numbers, int i, int sum, int target) {
        if (i == numbers.length) {
            if (sum == target) {
                count++;
            }
        } else {
            dfs(numbers, i + 1, sum + numbers[i], target);
            dfs(numbers, i + 1, sum - numbers[i], target);
        }
    }
}