import java.util.Arrays;
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
      	int[] arr = new int[n];
        
        for (int i = 0; i < section.length; i++) {
            arr[section[i] - 1] = 1;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                paint(arr, i, n, m);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void paint(int[] arr, int idx, int n, int m) {
        int endPoint = idx + m > n ? n : idx + m;
        for (int i = idx; i < endPoint; i++) {
            arr[i] = 0;
        }
    }
}