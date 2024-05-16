class Solution {
    public int[] solution(int brown, int yellow) {
       
        int totalSize = brown + yellow;
        
        for (int i = 1; i <= Math.sqrt(totalSize); i++) {
            int wid = totalSize / i;
            int len = i;
            
            if ((wid - 2) * (len - 2) == yellow) {
                return new int[] {wid, len};
            }
        }
        return new int[2];
    }
}