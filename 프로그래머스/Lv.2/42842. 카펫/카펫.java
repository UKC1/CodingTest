class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int width = brown + yellow;
        int yellowRec = yellow;
        
        
        for (int i = 1; i <= Math.sqrt(width); i++) {
            if (yellow % i == 0) {
                int wid = yellow / i;
                int len = i;
                while (wid * len < width) {
                    wid += 2;
                    len += 2;
                }
                if (wid * len == width) {
                    return new int[] {wid, len};
                }
                
            } 
        }
        return answer;
    }
}