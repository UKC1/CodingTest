import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<int[]> expireTimes = new ArrayDeque<>();
        int serverCnt = 0;
        for (int i = 0; i < players.length; i++) {
            // i ~ i + 1 시간 동안 들어온 플레이어 수
            
            // 증설이 필요한 상황
            // 현재 서버 수 x 감당 인원 수 보다 크다면
            if (players[i] > serverCnt * m) {
                int addServer = (players[i] - serverCnt * m) / m;
                int expireTime = i + k;
                serverCnt += addServer;
                answer += addServer;
                expireTimes.offer(new int[] {addServer, expireTime});
            }
            
            while(!expireTimes.isEmpty() && expireTimes.peek()[1] == i + 1) {
                int removeServer = expireTimes.poll()[0];
                serverCnt -= removeServer;
            }
        }
        return answer;
    }
}