class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        // StringBuilder sb = new StringBuilder();
        for (int i = 0; i < picture.length; i++) {
            String str = "";
            for (int j = 0; j < picture[i].length(); j++) {
                for (int m = 0; m < k; m++) {
                      str += picture[i].charAt(j);
                }
            }
            
            for (int j = 0; j < k; j++) {
                answer[i * k + j] = str;
            }
        }
        
        return answer;
    }
}