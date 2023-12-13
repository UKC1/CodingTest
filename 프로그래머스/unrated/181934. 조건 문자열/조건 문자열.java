class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        String status = ineq + eq;
        if (ineq.equals(">")) {
            if (eq.equals("=")) {
                answer = n >= m ? 1 : 0;
            } else if (eq.equals("!")) {
                answer = n > m ? 1 : 0;
            }
        } else if (ineq.equals("<")) {
            if (eq.equals("=")) {
                answer = n <= m ? 1 : 0;
            } else if (eq.equals("!")) {
                answer = n < m ? 1 : 0;
            }
        }
        
        return answer;
    }
}