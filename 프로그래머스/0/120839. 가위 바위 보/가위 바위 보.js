function solution(rsp) {
    var answer = '';
    for (str of rsp) {
        if (str == 2) {
            answer += '0';
        } else if (str == 0) {
            answer += '5';
        } else {
            answer += '2';
        }
    }
    return answer;
}