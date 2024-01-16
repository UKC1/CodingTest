import java.util.Arrays;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] arr = new int[10000001];
        
        for (int i = 0; i < tangerine.length; i++) {
            arr[tangerine[i]]++;
        }
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            if (k <= 0) {
                break;
            } else {
                k -= arr[i];
                answer++;
            }
        }
        return answer;
    }
}