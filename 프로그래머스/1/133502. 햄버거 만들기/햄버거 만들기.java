import java.util.Stack;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < ingredient.length; i++) {
            stack.push(ingredient[i]);
            while(stack.size() > 3) {
                if(stack.peek() == 1) {
                    int four = stack.pop();
                    if(stack.peek() == 3) {
                    	int three = stack.pop();
                        if(stack.peek() == 2) {
                            int two = stack.pop();
                            if (stack.peek() == 1) {
                                int one = stack.pop();
                                answer++;
                                break;
                            } else {
                                stack.push(two);
                                stack.push(three);
                                stack.push(four);
                                break;
                            }
                        } else {
                            stack.push(three);
                            stack.push(four);
                            break;
                        }
                    } else {
                        stack.push(four);
                        break;
                    }
                } else {
                    break;
                }
            } 
            
               
        }
       
        return answer;
    }
}