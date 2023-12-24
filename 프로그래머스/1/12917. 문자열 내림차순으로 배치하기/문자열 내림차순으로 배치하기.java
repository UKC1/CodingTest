import java.util.Arrays;

class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.reverse().toString();
    }
}