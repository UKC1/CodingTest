import java.util.HashSet;
import java.util.Set;

class Solution {
    // 방향별 이동을 나타내는 좌표 변화
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public int solution(int[] arrows) {
        Set<String> visited = new HashSet<>();  // 방문한 좌표를 저장
        Set<String> edges = new HashSet<>();    // 방문한 경로를 저장
        int answer = 0;

        // 초기 위치
        int x = 0, y = 0;
        visited.add(encode(x, y));

        // 주어진 방향에 따라 이동
        for (int dir : arrows) {
            for (int j = 0; j < 2; j++) { // 교차 처리를 위해 2번 이동
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                String currentPos = encode(x, y);
                String nextPos = encode(nx, ny);
                String edge = encodeEdge(currentPos, nextPos);

                if (visited.contains(nextPos) && !edges.contains(edge)) {
                    answer++;  // 새로운 방 발견
                }

                visited.add(nextPos); // 새로운 좌표 방문 처리
                edges.add(edge);      // 새로운 경로 방문 처리

                // 좌표 이동
                x = nx;
                y = ny;
            }
        }

        return answer;
    }

    // 좌표를 문자열로 인코딩
    private String encode(int x, int y) {
        return x + "," + y;
    }

    // 경로를 문자열로 인코딩
    private String encodeEdge(String pos1, String pos2) {
        if (pos1.compareTo(pos2) < 0) {
            return pos1 + "->" + pos2;
        } else {
            return pos2 + "->" + pos1;
        }
    }
}
