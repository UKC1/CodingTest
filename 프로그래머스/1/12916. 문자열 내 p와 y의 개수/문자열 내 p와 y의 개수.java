class Solution {
    boolean solution(String s) {
        String str = s.toLowerCase();
        int pLen = str.length() - str.replace("p", "").length();
		int yLen = str.length() - str.replace("y", "").length();
        
        boolean answer = pLen == yLen ? true : false;
    
        return answer;
    }
}