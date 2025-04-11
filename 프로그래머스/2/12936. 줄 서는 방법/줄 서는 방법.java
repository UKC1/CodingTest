import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        k--; // 0-based index

        for (int i = 0; i < n; i++) {
            fact = fact / (n - i);
            int index = (int)(k / fact);
            answer[i] = numbers.get(index);
            numbers.remove(index);
            k = k % fact;
        }

        return answer;
    }
}
