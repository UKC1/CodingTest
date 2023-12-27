class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] patterns = {"aya", "ye", "woo", "ma"};

        for (String word : babbling) {
            String currentWord = word;
            boolean isValid = true;
            String lastPattern = "";

            while (!currentWord.isEmpty() && isValid) {
                boolean foundPattern = false;
                for (String pattern : patterns) {
                    if (currentWord.startsWith(pattern) && !pattern.equals(lastPattern)) {
                        currentWord = currentWord.substring(pattern.length());
                        lastPattern = pattern;
                        foundPattern = true;
                        break;
                    }
                }
                isValid = foundPattern;
            }

            if (isValid && currentWord.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}
