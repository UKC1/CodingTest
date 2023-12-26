class Solution {
    public int[] solution(String s) {
        char[] arr = s.toCharArray();
        int[] answer = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            boolean single = true;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    single = false;
                    answer[i] = i - j;
                } 
            }
            if (single) {
                answer[i] = -1;
            } else if (!single && answer[i] == 0) {
                answer[i] = -1;
            }
        }
        return answer;
    }
}