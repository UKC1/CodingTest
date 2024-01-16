import java.util.LinkedHashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        LinkedHashSet<String> set = new LinkedHashSet();
        for (int i = 0; i < words.length; i++) {
            set.add(words[i]);
            if (set.size() != i + 1) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            } 
        }
        
        int idx = 0;
        String s = words[0];
        for (String str : set) {
            if (idx > 0) {
                if (s.charAt(s.length() - 1) != str.charAt(0)) {
                    answer[0] = idx % n + 1;
                    answer[1] = idx / n + 1;
                    break;
                } else {
                    s = str;
                }
            }
            idx++;
        }
        return answer;
    }
}