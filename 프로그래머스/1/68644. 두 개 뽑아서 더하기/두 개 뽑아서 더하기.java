import java.util.TreeSet;

class Solution {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> set = new TreeSet();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        int idx = 0;
        int[] answer = new int[set.size()];
        for (Integer i : set) {
            answer[idx++] = i;
        }
        
        return answer;
    }
}