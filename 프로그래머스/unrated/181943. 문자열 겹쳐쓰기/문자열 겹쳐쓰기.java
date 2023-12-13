class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        StringBuilder sb = new StringBuilder();
        int over_len = overwrite_string.length();
        int my_len = my_string.length();
        
        sb.append(my_string.substring(0, s));
        sb.append(overwrite_string);
        sb.append(my_string.substring(s + over_len, my_len));
        
        return sb.toString();
    }
}