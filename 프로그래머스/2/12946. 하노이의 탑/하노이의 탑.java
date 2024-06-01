import java.util.*;
class Solution {
    public int[][] solution(int n) {
        List<int[]> moves = new ArrayList<>();
        solveHanoi(n, 1, 2, 3, moves);
        
        int[][] result = new int[moves.size()][2];
        for (int i = 0; i < moves.size(); i++) {
            result[i] = moves.get(i);
        }
        
        return result;
    }
    
     private void solveHanoi(int n, int start, int auxiliary, int end, List<int[]> moves) {
        if (n == 1) {
            moves.add(new int[]{start, end});
        } else {
            solveHanoi(n - 1, start, end, auxiliary, moves);
            moves.add(new int[]{start, end});
            solveHanoi(n - 1, auxiliary, start, end, moves);
        }
    }
}