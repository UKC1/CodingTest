class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (String word : babbling) {
            word = word.replace("aya", "1")
                       .replace("ye", "2")
                       .replace("woo", "3")
                       .replace("ma", "4");

            if (word.matches("^[1-4]+$") && !word.matches(".*(11|22|33|44).*")) {
                answer++;
            }
        }
        
        return answer;
    }
}