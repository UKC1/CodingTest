import java.util.Stack;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> pang = new Stack();
        for (int i = 0; i < moves.length; i++) {
            int row = 0;
            int col = moves[i] - 1;
            // moves[i] - 1=> 1열
            while(row < board[0].length) {
                if(board[row][col] == 0) {
                    row++;
                } else {
                    if (!pang.isEmpty() && pang.peek() == board[row][col]) {
                        answer += 2;
                        pang.pop();
                    } else {
                         pang.push(board[row][col]);
                    }
                    board[row][col] = 0;
                    break;
                }
            }
        }
        System.out.println(pang);
        
        return answer;
    }
}