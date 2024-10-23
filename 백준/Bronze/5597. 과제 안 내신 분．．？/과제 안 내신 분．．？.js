// 입력을 받는 부분
const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n').map(Number);

// 1부터 30까지의 학생 번호 배열
const totalStudents = Array.from({ length: 30 }, (_, i) => i + 1);

// 출석한 학생들의 번호를 제거하는 방법
input.forEach((student) => {
    const index = totalStudents.indexOf(student);
    if (index !== -1) {
        totalStudents.splice(index, 1); // 출석한 학생은 리스트에서 제거
    }
});

// 출석하지 않은 학생들 출력
console.log(totalStudents[0]);
console.log(totalStudents[1]);