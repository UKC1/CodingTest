import java.util.Set;
import java.util.LinkedHashSet;

class Solution {
    public int[] solution(int[] arr, int k) {
        Set<Integer> set = new LinkedHashSet<Integer>();
        
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        
        int[] answer = new int[k];
        
       
        int idx = 0;
        for (Integer i : set) {
            if (idx == k) {
                break;
            }
            answer[idx] = i;
            idx++;
        }
        for (int i = idx; i < answer.length; i++) {
            answer[i] = -1;
        }
        
        return answer;
    }
}