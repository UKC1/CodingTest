import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int findIdx = commands[i][2] - 1;

            int[] arr = new int[end - start];
            System.arraycopy(array, start, arr, 0, end - start);
            Arrays.sort(arr);

            answer[i] = arr[findIdx];
        }
        return answer;
    }
}
