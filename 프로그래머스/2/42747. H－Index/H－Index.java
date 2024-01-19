import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int hIdx = 0;
        
        for (int i = 0; i <= citations[n - 1]; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i <= citations[j]) {
                    cnt++;
                }
            }
            
            if (cnt >= i && i >= n - cnt) {
                hIdx = i;
            }
        }
        return hIdx;
    }
}