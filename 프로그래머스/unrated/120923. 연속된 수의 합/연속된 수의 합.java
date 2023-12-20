class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int first = total * 2 / num - num + 1;
        for (int i = 0; i < num; i++) {
            answer[i] = i + first / 2;
        }
        return answer;
    }
}