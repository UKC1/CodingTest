class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] check = new int[202];
        
        for (int[] line : lines) {
            for (int j = line[0]; j < line[1]; j++) {
                check[j + 100]++;
            }
        }        
        
        for (int i = 0; i < check.length; i++) {
            if (check[i] > 1) {
                answer++;
            }
        }
        return answer;
    }
}
