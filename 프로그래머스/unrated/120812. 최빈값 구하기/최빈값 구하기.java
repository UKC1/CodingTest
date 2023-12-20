import java.util.*;

class Solution {
    public int solution(int[] array) {
        int lenMax = Arrays.stream(array).max().getAsInt();
        int[] arr = new int[lenMax + 1];
        
        for(int num : array) {
            arr[num]++;  
        }
        
        int count = 0;
        int arrMax = Arrays.stream(arr).max().getAsInt();
        int idx = 0;
        for(int i = 0 ; i < arr.length;i++) {
            if(arrMax == arr[i]) {                
                count++;
                idx = i;
            }
        }
        return count == 1 ? idx : -1;
    }
}