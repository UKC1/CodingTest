class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        boolean isFirst = true;
        boolean isMiddleBlank;
        
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == ' ') {
                isFirst = true;
                sb.append(arr[i]);
            } else {
                if(isFirst) {
                    sb.append(Character.toUpperCase(arr[i]));
                    isFirst = false;
                } else {
                    sb.append(Character.toLowerCase(arr[i]));
                }
            }
         }
        
        return sb.toString();
    }
}