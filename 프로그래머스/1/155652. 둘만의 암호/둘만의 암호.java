import java.util.Arrays;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        int[] arr = new int[26];
        
        for (int i = 0; i < skip.length(); i++) {
            arr[skip.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = 0;
            while(idx < index || arr[(c - 'a') % 26] == 1) {
                idx++;
                c = (char) ((c + 1 - 'a') % 26 + 'a');
                if(arr[(c - 'a') % 26] == 1) {
                    idx--;
                }
            }
            answer += c;
        }
        
        return answer;
    }
}