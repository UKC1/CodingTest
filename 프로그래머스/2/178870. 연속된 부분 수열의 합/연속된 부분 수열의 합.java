import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int start = 0, end = 0, sum = 0;
        int minLength = Integer.MAX_VALUE; // 최소 길이를 저장하기 위한 변수

        while (end < sequence.length) {
            // 현재 구간 합에 값을 더함
            sum += sequence[end];

            // 구간 합이 k 이상일 때
            while (sum >= k) {
                // 합이 k와 같고, 구간 길이가 최소일 때 결과 갱신
                if (sum == k && (end - start + 1) < minLength) {
                    answer[0] = start;
                    answer[1] = end;
                    minLength = end - start + 1;
                }
                // 구간의 시작을 줄이며 합에서 값을 뺌
                sum -= sequence[start];
                start++;
            }
            end++;
        }
        return answer;
    }
}
