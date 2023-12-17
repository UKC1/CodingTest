import java.util.Arrays;

class Solution {
    public int solution(int[] array) {
        
        Arrays.sort(array);
        int[] arr = new int[array[array.length - 1] + 1];
        for (int i = 0; i < array.length; i++) {
            arr[array[i]]++;
        }
        
        int max = 0;
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                idx = i;
            }
        }
        
        Arrays.sort(arr);
        if (arr.length >= 2 && arr[arr.length - 2] == max) {
            return -1;
        }
        
        return idx;
    }
}