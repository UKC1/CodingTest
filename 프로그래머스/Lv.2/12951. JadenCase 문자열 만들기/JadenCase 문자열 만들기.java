class Solution {
    public String solution(String s) {
        String answer = s.toLowerCase();
        String check = "";
        // boolean ch = true;
        String[] str = answer.split(" ");
        for (int i = 0; i < str.length; i++) {
            // if (str[i].isEmpty()) {
            //      check += " ";
            //      ch = false;} 
            if (!str[i].isEmpty()) {
                check += str[i].substring(0, 1).toUpperCase();
                check += str[i].substring(1);
                if (i != str.length - 1) {
                    check += " ";
                }
                // ch = true;

             } else {
                 check += str[i];
                 if (i != str.length - 1) {
                     check += " ";
                 }
                // ch = true;
             }
        }
        if (s.length() != check.length()) {
            check += " ";
        }
        return check;
    }
}