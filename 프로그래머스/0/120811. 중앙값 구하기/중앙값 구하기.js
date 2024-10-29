function solution(array) {
    array.sort((a, b) => a - b); // 숫자 오름차순 정렬
    const answer = array[~~(array.length / 2)];
    return answer;
}
