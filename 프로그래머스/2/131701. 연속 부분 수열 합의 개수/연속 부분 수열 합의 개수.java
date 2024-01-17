import java.util.TreeSet;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        TreeSet<Integer> set = new TreeSet();
        int n = 1;
        while(n <= elements.length) {
            for (int i = 0; i < elements.length; i++) {
                answer = 0;
                for (int j = i; j < i + n; j++) {
                    answer += elements[j % elements.length];
                }
                set.add(answer);
            }    
            n++;
        }
        return set.size();
    }
}