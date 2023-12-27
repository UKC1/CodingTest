class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            StringBuilder sb = new StringBuilder();
            while(sb.length() < n) {
                if (arr1[i] % 2 == 1 || arr2[i] % 2 == 1) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
                arr1[i] /= 2;
                arr2[i] /= 2;
            }
            answer[i] = sb.reverse().toString();
        }
        return answer;
    }
}