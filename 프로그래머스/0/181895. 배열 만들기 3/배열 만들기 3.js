function solution(arr, intervals) {
    var answer = [];
    for (let i = 0; i < intervals.length; i++) {
        let start = intervals[i][0];
        let end = intervals[i][1];
        for (let j = start; j <= end; j++) {
            answer.push(arr[j]);
        }
    }
    return answer;
}