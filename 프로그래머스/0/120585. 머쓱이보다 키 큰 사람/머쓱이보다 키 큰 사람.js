function solution(array, height) {
    var answer = 0;
    for (let bigMan of array) {
        if (height < bigMan) {
            answer++;
        }
    }
    return answer;
}