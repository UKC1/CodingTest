var cnt = 0;
function solution(numbers, target) {
    dfs(numbers, 0, 0, target);
    return cnt;
}

function dfs(numbers, idx, sum, target) {
    if (idx == numbers.length) {
        if (sum == target) {
            cnt++;
        }
        return;
    }
    
    dfs(numbers, idx + 1, sum + numbers[idx], target);
    dfs(numbers, idx + 1, sum - numbers[idx], target);
}