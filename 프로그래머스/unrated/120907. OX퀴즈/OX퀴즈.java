class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for (int i = 0; i < quiz.length; i++) {
            boolean ck = false;
            int n1 = Integer.parseInt(quiz[i].split(" ")[0]);
            int n2 = Integer.parseInt(quiz[i].split(" ")[2]);
            int n3 = Integer.parseInt(quiz[i].split(" ")[4]);
            String op = quiz[i].split(" ")[1];
            
            if (op.equals("+")) {
                ck = n1 + n2 == n3;
            } else {
                ck = n1 - n2 == n3;
            } 
            
            if (ck) {
                answer[i] = "O";
            } else {
                answer[i] = "X";
            }
        }
        return answer;
    }
}