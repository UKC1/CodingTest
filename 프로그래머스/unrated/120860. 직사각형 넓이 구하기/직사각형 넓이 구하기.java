class Solution {
    public int solution(int[][] dots) {
        int width = dots[0][0];
        int length = dots[0][1];
        
        for (int i = 1; i < dots.length; i++) {
            if (width != dots[i][0]) {
                width -= dots[i][0];
                break;
            }
        }
        
        for (int i = 1; i < dots.length; i++) {
            if (length != dots[i][1]) {
                length -= dots[i][1];
                break;
            }
        }
            
            
        return (int) Math.abs(width * length);
    }
}