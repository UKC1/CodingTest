import java.util.*;

class Solution {
    private int maxDungeons = 0; // 최대로 탐험할 수 있는 던전 수를 저장하는 변수

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length]; // 각 던전의 방문 여부를 저장
        explore(dungeons, visited, k, 0);
        return maxDungeons;
    }

    private void explore(int[][] dungeons, boolean[] visited, int fatigue, int count) {
        maxDungeons = Math.max(maxDungeons, count);
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && fatigue >= dungeons[i][0]) { // 방문하지 않았고, 탐험할 수 있는 에너지가 충분한 경우
                visited[i] = true; // 해당 던전을 방문 표시
                explore(dungeons, visited, fatigue - dungeons[i][1], count + 1); // 다음 던전 탐색
                visited[i] = false; // 백트래킹: 다른 모든 가능성을 탐색하기 위해 방문 표시를 원상 복구
            }
        }
    }
}
