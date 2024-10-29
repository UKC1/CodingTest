function solution(price) {
    var answer = 0;
    if (price >= 500000) {
        answer = 20;
    } else if (price >= 300000) {
        answer = 10;
    } else if (price >= 100000) {
        answer = 5;
    }
    
    answer = price - Math.ceil(price * answer / 100);
    return answer;
}