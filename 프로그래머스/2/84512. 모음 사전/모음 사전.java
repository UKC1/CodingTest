import java.util.*;

class Solution {
    static String[] letters = {"A", "E", "I", "O", "U"};
    static int answer = 0;
    static int count = 0;
    
    public int solution(String word) {
        dfs("", word);
        return answer;
    }
    
    private void dfs(String current, String target) {
        // 단어가 목표 단어와 일치할 때의 순서를 기록
        if (current.equals(target)) {
            answer = count;
            return;
        }
        
        // 단어의 길이가 5를 넘지 않도록 제한
        if (current.length() >= 5) {
            return;
        }
        
        // 각 글자를 추가하면서 새로운 단어를 생성
        for (int i = 0; i < letters.length; i++) {
            count++;  // 생성된 단어의 순서를 증가시킴
            dfs(current + letters[i], target);  // 다음 단계의 단어 생성
        }
    }
}
