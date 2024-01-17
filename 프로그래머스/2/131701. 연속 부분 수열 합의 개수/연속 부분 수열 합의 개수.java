import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> distinctSums = new HashSet<>();
        int n = elements.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < i + n; j++) {
                sum += elements[j % n];
                distinctSums.add(sum);
            }
        }

        return distinctSums.size();
    }
}
