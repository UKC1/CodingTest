var count = 0;
function solution(numbers, target) {
    dfs(numbers, target, 0, 0);
    return count;
}

function dfs (numbers, target, sum, idx) {
    if (idx == numbers.length) {
        if (target == sum) {
            count++;
        }
        return;
    }
    
    dfs(numbers, target, sum + numbers[idx], idx + 1);
    dfs(numbers, target, sum - numbers[idx], idx + 1);
}