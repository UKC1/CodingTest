import java.util.Arrays;
class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        int[] xArr = new int[10];
        int[] yArr = new int[10];
        
        for (int i = 0; i < Y.length(); i++) {
            yArr[Y.charAt(i) - '0']++;
        }
        
        for (int i = 0; i < X.length(); i++) {
            xArr[X.charAt(i) - '0']++;
        }
        
        for (int i = 0; i < xArr.length; i++) {
            if (xArr[i] != 0 && yArr[i] != 0) {
                sb.append(Integer.toString(i).repeat(xArr[i] < yArr[i] ? xArr[i] : yArr[i]));
            }
        }
        if (sb.toString().equals("")) {
            return "-1";
        }
        
        char[] arr = sb.toString().toCharArray();
        Arrays.sort(arr);
        
        sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.reverse().toString().charAt(0) == '0' ? "0" : sb.toString();
    }
}