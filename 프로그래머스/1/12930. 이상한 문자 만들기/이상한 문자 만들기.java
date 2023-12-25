import java.util.Arrays;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        int ck = 1;
    
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                sb.append(arr[i]);
                ck = 1;
            } else if (ck == 1) {
                sb.append(Character.toUpperCase(arr[i]));
                ck *= -1;
            } else if (ck == -1) {
                sb.append(Character.toLowerCase(arr[i]));
                ck *= -1;
            }
        }
        return sb.toString();
    }
}