import java.util.*;

class Solution {
    int minCnt = Integer.MAX_VALUE;
    Map<Integer, Integer> memo = new HashMap<>();

    public int solution(int storey) {
        dfs(storey, 0);
        return minCnt;
    }
    
    void dfs(int currentNum, int cnt) {
        // 가지치기: 현재 경로가 이미 최소값보다 크면 중단
        if (cnt >= minCnt) {
            return;
        }

        // 종료 조건: 한 자리 숫자일 때
        if (currentNum < 10) {
            minCnt = Math.min(minCnt, cnt + Math.min(currentNum, 10 - currentNum + 1));
            return;
        }

        // 메모이제이션: 이미 계산된 최소값이 있다면 탐색 중단
        if (memo.containsKey(currentNum) && memo.get(currentNum) <= cnt) {
            return;
        }
        memo.put(currentNum, cnt);

        // 현재 숫자의 1의 자리 처리
        int r = currentNum % 10;
        int nextNum = currentNum / 10;

        // 1. 현재 자리에서 그대로 빼는 경우
        dfs(nextNum, cnt + r);

        // 2. 현재 자리에서 올림하여 다음 자리 처리
        dfs(nextNum + 1, cnt + (10 - r));
    }
}
