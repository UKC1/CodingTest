class Solution {
    boolean solution(String s) {
        char[] arr = s.toCharArray();
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                cnt++;
            } else {
                cnt--;
            }
            
            if (cnt < 0) {
                break;
            }
        }
        return cnt == 0;
    }
}