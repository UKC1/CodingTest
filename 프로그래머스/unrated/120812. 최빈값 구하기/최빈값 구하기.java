import java.util.*;

class Solution {
    public int solution(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        int[] arr = new int[max + 1];
        
        for(int i = 0; i < array.length;i++){
            arr[array[i]]++;  
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