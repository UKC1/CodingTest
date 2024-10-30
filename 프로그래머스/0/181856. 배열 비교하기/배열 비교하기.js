function solution(arr1, arr2) {
    if (arr1.length > arr2.length) {
        return 1;
    } else if (arr1.length < arr2.length) {
        return -1;
    }
    
    var sumArr1 = 0;
    var sumArr2 = 0;
    for (let i in arr1) {
        sumArr1 += arr1[i];
        sumArr2 += arr2[i];
    }
    if (sumArr1 === sumArr2) return 0;
    
    return sumArr1 > sumArr2 ? 1 : -1;
}