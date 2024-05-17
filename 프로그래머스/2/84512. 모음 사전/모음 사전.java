class Solution {
    public int solution(String word) {
        int[] weights = {781, 156, 31, 6, 1}; // 각 자리별 가중치
        char[] characters = {'A', 'E', 'I', 'O', 'U'}; // 사용 가능한 문자
        int answer = 0;

        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < characters.length; j++) {
                if (word.charAt(i) == characters[j]) {
                    answer += 1 + j * weights[i]; // 현재 글자가 기여하는 순서 수를 더함
                }
            }
        }
        
        return answer;
    }
}
