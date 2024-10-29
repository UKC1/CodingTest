function solution(a, b, flag) {
    var answer = a + b;
    if (!flag) {
        answer = a - b;
    }
    return answer;
}