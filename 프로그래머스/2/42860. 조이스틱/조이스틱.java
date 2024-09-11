class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int move = length - 1; // 좌우 움직임을 최소화하는 변수

        for (int i = 0; i < length; i++) {
            // 해당 문자를 'A'로 만드는데 드는 조작 횟수 계산
            int upCnt = name.charAt(i) - 'A';
            int downCnt = 'Z' - name.charAt(i) + 1;
            answer += Math.min(upCnt, downCnt);

            // 다음 'A'가 아닌 문자를 찾기 위한 탐색
            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }

            // 좌우 움직임 중 최소값 갱신
            move = Math.min(move, i + length - next + Math.min(i, length - next));
        }

        answer += move;
        return answer;
    }
}
