class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int totalSeconds = convertSeconds(video_len);
        int currentSeconds = convertSeconds(pos);
        int opStartSeconds = convertSeconds(op_start);
        int opEndSeconds = convertSeconds(op_end);
        for (String command : commands) {
            if (currentSeconds >= opStartSeconds && currentSeconds <= opEndSeconds) {
                    currentSeconds = opEndSeconds;
            }
            
            if (command.equals("prev")) {
                // 1. 시간 값이 0분 0초 보다 작을 수는 없음
                // 2. 뒤로 10초 이동
                currentSeconds = Math.max(0, currentSeconds - 10);
            } else if (command.equals("next")) {
                // 1. 시간 값이 video_len 보다 클 수는 없음
                // 2. 앞으로 10초 이동 
                // 이동한 후 시간이 오프닝 시작 ~ 끝 이면 오프닝 끝 시간으로 이동
                currentSeconds = Math.min(totalSeconds, currentSeconds + 10);
            } 
        }
        
        if (currentSeconds >= opStartSeconds && currentSeconds <= opEndSeconds) {
                    currentSeconds = opEndSeconds;
        }
        String finalTime = convertTime(currentSeconds);
        return finalTime;
    }
    
    String convertTime(int currentSeconds) {
        String min = Integer.toString(currentSeconds / 60);
        String second = Integer.toString(currentSeconds % 60);
        if (min.length() == 1) {
            min = "0" + min;
        } 
        
        if (second.length() == 1) {
            second = "0" + second;
        }
        return min + ":" + second;
    }
    
    int convertSeconds(String time) {
        String[] times = time.split(":");
        int minToSeconds = Integer.parseInt(times[0]) * 60;
        int seconds = Integer.parseInt(times[1]);
        return minToSeconds + seconds;
    }
}