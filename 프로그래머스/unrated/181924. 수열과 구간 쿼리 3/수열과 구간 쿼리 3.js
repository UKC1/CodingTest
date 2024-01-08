function solution(arr, queries) {
    
    for(let i = 0; i < queries.length; i++) {
        let before = queries[i][0];
        let after = queries[i][1];
        let tmp = arr[before];
        arr[before] = arr[after];
        arr[after] = tmp;
    }
    return arr;
}