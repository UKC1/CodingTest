class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        boolean first = true;
        for (int i = 0; i < wallpaper.length; i++) {
            for(int j = 0; j < wallpaper[i].length(); j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    if (first) {
                        answer[0] = i;
                        answer[1] = j;
                        answer[2] = i;
                        answer[3] = j;
                        first = false;
                    } else {
                        answer[0] = answer[0] < i ? answer[0] : i;
                        answer[2] = answer[2] > i ? answer[2] : i;
                        answer[1] = answer[1] < j ? answer[1] : j;
                        answer[3] = answer[3] > j ? answer[3] : j;
                    }
                }
            }
        }
        answer[2]++;
        answer[3]++;
        return answer;       
    }
}