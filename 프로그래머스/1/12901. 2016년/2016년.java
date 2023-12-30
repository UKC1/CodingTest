class Solution {
    public String solution(int a, int b) {
        int[] end = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        
        int allDay = b - 1;
        for (int i = 0; i < a - 1; i++) {
            allDay += end[i];
        }
        
        return day[allDay % 7];
    }
}