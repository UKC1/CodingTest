class Solution {
    int minMove;
    public int solution(String name) {
        int n = name.length();
        int answer = 0;

        // 1. 문자 조작 (위/아래로 움직이는 최소 횟수 계산)
        int totalCnt = 0;
        for (int i = 0; i < n; i++) {
            int upCnt = name.charAt(i) - 'A'; // 위로 움직이는 경우
            int downCnt = 'Z' - name.charAt(i) + 1; // 아래로 움직이는 경우
            answer += Math.min(upCnt, downCnt);
            if (name.charAt(i) != 'A') totalCnt++;
        }

        // 2. 좌우 이동 (최소 이동 거리 계산)
        minMove = n - 1;
        boolean[] visited = new boolean[n];
        if (name.charAt(0) != 'A') {
            totalCnt--;
            visited[0] = true;
        }
        dfs(visited, n, totalCnt, name, 0, 0, 0);
            

        answer += minMove;
        return answer;
    }
    
    void dfs(boolean[] visited, int n, int totalCnt, String name, int move, int current, int cnt) {
        if (cnt == totalCnt) {
            minMove = Math.min(minMove, move);
            return;
        }
        
        int left = current - 1;
        int right = current + 1;
        int leftMove = 0;
        int rightMove = 0;
        
        while (true) {
            if (left < 0) left += n;
            if (name.charAt(left) != 'A' && !visited[left]) {
                int leftCnt = Math.abs(current - left);
                leftMove = Math.min(leftCnt, n - leftCnt);
                break;
            }
            left--;
        }
        
        while (true) {
            if (right >= n) right -= n;
            if (name.charAt(right) != 'A' && !visited[right]) {
                int rightCnt = Math.abs(current - right);
                rightMove = Math.min(rightCnt, n - rightCnt);
                break;
            }
            right++;
        }
        visited[left] = true;
        dfs(visited, n, totalCnt, name, move + leftMove, left, cnt + 1);
        visited[left] = false;
        visited[right] = true;
        dfs(visited, n, totalCnt, name, move + rightMove, right, cnt + 1);
        visited[right] = false;
    }
}
