import java.util.Stack;
class Solution
{
    public int solution(String s)
    {
        boolean twice = false;
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);    
            } else {
                if(stack.peek() == c) {
                    stack.push(c);
                    stack.pop();
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
    

        return stack.isEmpty() ? 1 : 0;
    }
}