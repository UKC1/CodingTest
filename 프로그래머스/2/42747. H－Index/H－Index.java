import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int idx = 0;
        int count = 0;
        while(idx <= citations.length - count) {
            count = 0;
            for (int i = 0; i < citations.length; i++) {
                if (idx >= citations[i]) {
                    count++;
                }
            
             }
            idx++;
        }
        
        return idx - 1;
        
    }
}