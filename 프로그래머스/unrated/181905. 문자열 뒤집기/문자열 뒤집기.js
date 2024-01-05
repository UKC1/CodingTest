
function reverseString(str) {
    return str.split('').reverse().join('');
}

function solution(my_string, s, e) {
    let front = my_string.substring(0, s);
    let back = my_string.substring(e + 1, my_string.length);

    let reversedStr = reverseString(my_string.substring(s, e + 1));  
    return front + reversedStr + back;
    
}