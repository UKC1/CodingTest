import java.util.*;
class Solution {
    public int[][] solution(int n) {
        List<int[]> moves = new ArrayList();
        solvedHanoi(n, 1, 2, 3, moves);
        int[][] answer = new int[moves.size()][2];
        for (int i = 0; i < moves.size(); i++) {
            answer[i] = moves.get(i);
        }
        return answer;
    }
    
    public void solvedHanoi(int n, int start, int middle, int end, List<int[]> moves) {
        if (n == 1) {
            moves.add(new int[]{start, end});
            return;
        } else {
            solvedHanoi(n - 1, start, end, middle, moves);
            moves.add(new int[]{start, end});
            solvedHanoi(n - 1, middle, start, end, moves);
        }
    }
}