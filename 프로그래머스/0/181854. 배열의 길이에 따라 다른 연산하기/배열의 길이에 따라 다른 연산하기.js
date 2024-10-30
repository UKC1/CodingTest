function solution(arr, n) {
    var idx = 0;
    if (arr.length % 2 === 1) {
        return arr.map(num => idx++ % 2 === 0 ? num + n : num);
    } else {
        return arr.map(num => idx++ % 2 === 1 ? num + n : num);
    }
}