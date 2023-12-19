class Solution {
    public String solution(String code) {
        char[] arr = code.toCharArray();
        boolean mode = false;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1') {
                mode = !mode;
            } else if (mode) {
                if (i % 2 != 0) {
                    sb.append(arr[i]);
                }
            } else if (!mode) {
                if (i % 2 == 0) {
                    sb.append(arr[i]);
                }
            }
        }
        
        return sb.toString().isEmpty() ? "EMPTY" : sb.toString();
    }
}