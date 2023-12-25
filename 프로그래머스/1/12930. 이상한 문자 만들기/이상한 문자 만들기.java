import java.util.Arrays;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        boolean isUpperCase = true;
    
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                sb.append(arr[i]);
                isUpperCase = true;
            } else if (isUpperCase) {
                sb.append(Character.toUpperCase(arr[i]));
                isUpperCase = false;
            } else if (!isUpperCase) {
                sb.append(Character.toLowerCase(arr[i]));
                isUpperCase = true;
            }
        }
        return sb.toString();
    }
}