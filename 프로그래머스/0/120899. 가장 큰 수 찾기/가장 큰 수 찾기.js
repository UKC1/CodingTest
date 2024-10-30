function solution(array) {
    var maxNum = Math.max(... array);
    return [maxNum, array.indexOf(maxNum)];
}