class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        int[] arr = new int[26];

        for (int i = 0; i < skip.length(); i++) {
            arr[skip.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

                int shiftedIndex = 0;
                while (shiftedIndex < index || arr[c - 'a'] == 1) {
                    c = (char) ((c - 'a' + 1) % 26 + 'a');
                    shiftedIndex++;
                    if (arr[c - 'a'] == 1) {
                        shiftedIndex--;
                    }
                    
                }
                answer += c;
        }
        return answer;
    }
}
