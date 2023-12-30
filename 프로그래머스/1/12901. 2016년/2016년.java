class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] end = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        
        int allDay = b - 1;
        for (int i = 0; i < a; i++) {
            allDay += end[i];
        }
        
        answer = day[allDay % 7];
        return answer;
    }
}