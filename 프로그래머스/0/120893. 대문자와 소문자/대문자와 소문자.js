function solution(my_string) {
    let answerArray = [];
    
    for (let i = 0; i < my_string.length; i++) {
        const char = my_string[i];
        if (char >= 'a' && char <= 'z') {
            answerArray.push(char.toUpperCase());
        } else {
            answerArray.push(char.toLowerCase());
        }
    }
    
    return answerArray.join('');
}
