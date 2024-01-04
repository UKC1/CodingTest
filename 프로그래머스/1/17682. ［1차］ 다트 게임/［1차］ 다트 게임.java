import java.util.Stack;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int num = 0;
        char[] arr = dartResult.replace("10", "@").toCharArray();
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 'S') {
                stack.push(num);
            } else if(arr[i] == 'D') {
                stack.push(num * num);
            } else if(arr[i] == 'T') {
                stack.push(num * num * num);
            } else if(arr[i] == '*') {
                int first = stack.pop() * 2;
                if (stack.isEmpty()) {
                    stack.push(first);
                    continue;
                } else {
                    int second = stack.pop() * 2;
                    stack.push(second);
                    stack.push(first);
                }
            } else if(arr[i] == '#') {
                stack.push(- stack.pop());
            } else if(arr[i] == '@') {
                num = 10;
            } else {
                num = arr[i] - '0';
            }
        } 
        
        while(!stack.isEmpty()) {
            answer += stack.pop();
        }
        
        return answer;
    }
}