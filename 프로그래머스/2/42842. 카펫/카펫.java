class Solution {
    public int[] solution(int brown, int yellow) {
        int totalWidth = brown + yellow;
        int[] answer = new int[2];
        for(int i = 1; i <= totalWidth; i++) {
            if (totalWidth % i == 0) {
                int width = totalWidth / i;
                int height = i;
                if ((width - 2) * (height - 2) == yellow) {
                    answer[0] = width;
                    answer[1] = height;
                    break;
                } 
            }
        }
        return answer;
    }
}