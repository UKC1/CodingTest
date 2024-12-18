let input = require('fs').readFileSync('/dev/stdin').toString().trim();
let num = parseInt(input);
let cnt = 99;

// num이 99 이하일 경우 바로 출력
if (num <= 99) {
    console.log(num);
} else {
    for (let i = 100; i <= num; i++) {
        if (isEqualDiff(i)) {
            cnt++;
        }
    }
    console.log(cnt);
}

function isEqualDiff(num) {
    let str = num.toString(); // 숫자를 문자열로 변환
    let diff = str[1] - str[0]; // 첫 두 자리의 차이 계산

    for (let j = 2; j < str.length; j++) {
        if (str[j] - str[j - 1] != diff) {
            return false; // 등차 수열이 아닌 경우
        }
    }
    return true; // 등차 수열일 경우
}