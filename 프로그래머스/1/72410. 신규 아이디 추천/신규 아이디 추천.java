class Solution {
    public String solution(String new_id) {
        String temp = new_id.toLowerCase();

      
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < temp.length(); i++) {
            char c = temp.charAt(i); 
            if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9' || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }
        
         // 연속된 마침표를 하나로 줄이는 과정
        String str = sb.toString();
        while (str.contains("..")) {
            str = str.replace("..", ".");
        }
        
        sb = new StringBuilder(str);
        if (sb.length() > 0 && sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }

        if (sb.length() == 0) {
            sb.append("a");
        }

        if (sb.length() >= 16) {
            sb = new StringBuilder(sb.substring(0, 15));
            if(sb.charAt(sb.length() - 1) == '.') {
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        while (sb.length() < 3) {
            sb.append(sb.charAt(sb.length() - 1));
        }

        return sb.toString();
    }
}
