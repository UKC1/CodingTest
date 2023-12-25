class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        char[] arr = s.toCharArray();
        
        if (arr.length != 4 && arr.length != 6) {
            return false;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] < '0' || arr[i] > '9')) {
                answer = false;
                break;
            } 
        }
        
        return answer;
    }
}