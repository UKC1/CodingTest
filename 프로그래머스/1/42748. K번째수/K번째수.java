import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int cnt = 0;
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int findIdx = commands[i][2] - 1;
            
            int[] arr = new int[end - start + 1];
            int idx = 0;
            for (int j = start; j <= end; j++) {
                arr[idx++] = array[j];
            }
            
            Arrays.sort(arr);
            answer[cnt++] = arr[findIdx];
            
        }
        return answer;
    }
}