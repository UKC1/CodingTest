import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        int h = 0;
        int hIdx = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] <= n - i && i + 1 <= citations[i]) {
                h = citations[i];
                hIdx = i;
            } 
        }
        if (h == 0) {
            for (int newH = h + 1; newH < citations[hIdx + 1]; newH++) {
                if (newH <= n - hIdx  && hIdx + 1 <= newH) {
                    h = newH;
                }
            }
        } else {
            for (int newH = h + 1; newH < citations[hIdx + 1]; newH++) {
                if (newH < n - hIdx  && hIdx + 1 <= newH) {
                    h = newH;
                }
            }    
        }
        
        return h;
    }
}