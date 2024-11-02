import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        // s가 n보다 작으면 각 요소가 1 이상이 될 수 없으므로 -1 반환
        if (s < n) return new int[] {-1};
        
        int[] answer = new int[n];
        
        // 기본 몫과 나머지를 계산
        int base = s / n;
        int remainder = s % n;
        
        // 배열을 기본 몫으로 초기화
        Arrays.fill(answer, base);
        
        // 나머지만큼을 뒤에서부터 하나씩 1씩 더함으로써 최대 곱을 보장
        for (int i = 0; i < remainder; i++) {
            answer[n - 1 - i]++;
        }
        
        return answer;
    }
}
