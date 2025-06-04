class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int idx = 0;
        int leftIdx = 0;
        int rightIdx = 0;
        while(idx < goal.length) {
            String target = goal[idx];
            boolean isUsed = false;
            if (leftIdx < cards1.length && cards1[leftIdx].equals(target)) {
                isUsed = true;
                leftIdx++;
            }
            
            if (rightIdx <cards2.length && cards2[rightIdx].equals(target)) {
                isUsed = true;
                rightIdx++;
            }
            
            if (!isUsed) {
                return "No";
            }
            idx++;
            
            
        }
        return answer;
    }
}