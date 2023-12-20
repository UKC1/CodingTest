import java.util.Arrays;
class Solution {
    public long solution(long n) {
        long answer = 0;
        String numStr = Long.toString(n);
        char[] arr = numStr.toCharArray();
        Arrays.sort(arr);
        
        for (int i = 0; i < arr.length; i++) {
            answer += (arr[i] - '0') * Math.pow(10, i); 
        }
        return answer;
    }
}