function solution(arr) {
    var answer = [];
    console.log(countPow(arr.length));
    while (countPow(arr.length) > arr.length) {
        arr.push(0);
    }
    return arr;
}

function countPow(num) {
    let cnt = 1;
    while (cnt < num) {
        cnt *= 2;
    }
    return cnt;
}