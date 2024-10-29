function solution(my_string) {
    var answer = 0;
    for (let num of my_string) {
        if (num > 0) {
            answer += parseInt(num);
        }
    }
    return answer;
}