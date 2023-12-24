import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length - 1];
        int min = Arrays.stream(arr).min().getAsInt();
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != min) {
                list.add(arr[i]);
            }
        }
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer.length <= 0 ? new int[] {-1} : answer;
    }
}