import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[] timeline = new int[24 * 60 + 10]; // 하루 1440분 + 추가 10분
        for (String[] book : book_time) {
            int startTime = toMinutes(book[0]);
            int endTime = toMinutes(book[1]) + 10;
            timeline[startTime]++;
            if (endTime < timeline.length) {
                timeline[endTime]--;
            }
        }

        int maxRooms = 0, currentRooms = 0;
        for (int change : timeline) {
            currentRooms += change;
            maxRooms = Math.max(maxRooms, currentRooms);
        }
        return maxRooms;
    }

    private int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}
