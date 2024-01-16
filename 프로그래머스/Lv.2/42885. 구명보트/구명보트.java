import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while(right > left) {
                        
            if (people[left] + people[right] <= limit) {
                left++;
                answer++;
            }
            right--;
        }
     
        return people.length - answer;
    }
}