class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            answer[i] = findNext(num);
        }

        return answer;
    }

    private long findNext(long num) {
        // 짝수인 경우
        if (num % 2 == 0) {
            return num + 1;
        }

        // 홀수인 경우: 가장 오른쪽 0을 찾아 1로 변경
        long smallestZero = (~num) & (num + 1); // 가장 오른쪽 0 위치
        long smallestOne = smallestZero >> 1;  // 그 바로 왼쪽의 1 위치
        return num + smallestZero - smallestOne;
    }
}
