class Solution {
    StringBuilder sb;

    public String solution(String p) {
        // 이미 올바른 괄호 문자열이면 그대로 반환
        if (isRightCover(p)) {
            return p;
        }

        sb = new StringBuilder();
        dfs(p);

        return sb.toString(); // 누적한 결과 반환
    }

    void dfs(String p) {
        if (p.isEmpty()) {
            return;
        }

        // 2. 문자열을 균형잡힌 괄호 문자열 u, 나머지 v로 분리
        int cnt = 0;
        int idx = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') cnt++;
            else cnt--;

            if (cnt == 0) {
                idx = i + 1;
                break;
            }
        }

        String u = p.substring(0, idx);
        String v = p.substring(idx);

        // 3. u가 올바른 괄호 문자열이라면
        if (isRightCover(u)) {
            sb.append(u);
            dfs(v);
        } else {
            sb.append("(");
            dfs(v);
            sb.append(")");

            // u의 첫, 마지막 문자 제거하고 나머지 괄호 방향 뒤집기
            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') {
                    sb.append(")");
                } else {
                    sb.append("(");
                }
            }
        }
    }

    // 올바른 괄호 문자열인지 체크
    boolean isRightCover(String p) {
        int check = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') check++;
            else check--;

            if (check < 0) return false; // 닫는 괄호가 먼저 나올 경우
        }
        return check == 0;
    }
}
