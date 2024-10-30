function solution(num_str) {
    var answer = 0;
    for (let num of num_str) {
        answer += parseInt(num);
    }
    return answer;
}