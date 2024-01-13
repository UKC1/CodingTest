class Solution {
    public int[] solution(String s) {
        int zeroCnt = 0;
        int changeNum = 0;
        while(!s.equals("1")) {
            String newStr = s.replace("0", "");
            zeroCnt += s.length() - newStr.length();
            s = Integer.toString(newStr.length(), 2);
            changeNum++;
        }
        int[] answer = {changeNum, zeroCnt};
        return answer;
    }
}