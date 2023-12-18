class Solution {
    public String solution(String polynomial) {
        String[] str = polynomial.split(" ");
        int num = 0;
        int c = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("x")) {
                num += 1;
            } else if (str[i].equals("+")) {
                continue;
            } else if (!str[i].contains("x")) {
                c += Integer.parseInt(str[i]);
            } else {
                num += Integer.parseInt(str[i].replace("x", ""));
            }
        }
        
        if (num == 0) {
            if (c == 0) {
                return "";
            } else {
                return c + "";
            }
        } else if (num == 1) {
            if (c == 0) {
                return "x";
            } else {
                return "x" + " + " + c;
            }
        } else {
            if (c == 0) {
                return num + "x";
            } else {
                return num + "x" + " + " + c;
            }
        }
    }
}