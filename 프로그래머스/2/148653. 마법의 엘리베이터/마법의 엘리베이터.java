import java.util.*;
class Solution {
    int minCnt = Integer.MAX_VALUE;
    public int solution(int storey) {
        dfs(storey, 0);
        return minCnt;
    }
    
    void dfs(int currentNum, int cnt) {
        if (currentNum < 10) {
            int lastCnt = Math.min(currentNum, 10 - currentNum + 1);
            minCnt = Math.min(minCnt, cnt + lastCnt);
            return;
        }
        // System.out.println(currentNum + " : " + cnt);
        
        int r = currentNum % 10;
        int nextNum = currentNum / 10;
        if (r == 0) {
            dfs(nextNum, cnt);
        } else {
            dfs(nextNum, cnt + r);
            dfs(nextNum + 1, cnt + 10 - r);
        }
    }
}