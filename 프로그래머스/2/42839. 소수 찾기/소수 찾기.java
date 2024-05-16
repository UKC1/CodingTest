import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        boolean[] used = new boolean[numbers.length()];
        Set<Integer> number = new HashSet();
        String current = "";
        permutation(current, numbers.toCharArray(), used, number);
        for (Integer num : number) {
            System.out.println(num);
            if(isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }
    
    void permutation(String current, char[] numbers, boolean[] used, Set<Integer> number) {
        if (!current.isEmpty()) {
            number.add(Integer.parseInt(current));
        }
        
        for (int i = 0; i < numbers.length; i++) {
            if (!used[i]) {
                used[i] = true;
                permutation(current + numbers[i], numbers, used, number);
                used[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num) {
        if (num < 2) {
            return false;
        } else if (num == 2 || num == 3) {
            return true;
        }
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}