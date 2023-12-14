class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        int idx = 0;
        for (int[] arr : score) {
            int rank = 1;
            for (int[] arr2 : score) {
                if (arr[0] + arr[1] < arr2[0] + arr2[1]) {
                    rank++;
                }
            }
            answer[idx++] = rank;
        }
        return answer;
    }
}