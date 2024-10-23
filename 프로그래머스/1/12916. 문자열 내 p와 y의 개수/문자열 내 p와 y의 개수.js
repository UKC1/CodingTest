function solution(s){
    var answer = true;
    var pCnt = 0;
    var yCnt = 0;
    s = s.toLowerCase();
    for (let i in s) {
        if (s[i] === "p") pCnt++;
        else if (s[i] === "y") yCnt++;
    }

    return pCnt === yCnt;
}