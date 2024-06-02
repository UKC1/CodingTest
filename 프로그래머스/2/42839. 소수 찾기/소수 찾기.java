import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set<Integer> numberSet = new HashSet<>();
        generatePermutations("", numbers.toCharArray(), new boolean[numbers.length()], numberSet);
        
        int maxNumber = numberSet.stream().mapToInt(i -> i).max().orElse(0);
        boolean[] primeArray = sieveOfEratosthenes(maxNumber);
        
        int answer = 0;
        for (int num : numberSet) {
            if (primeArray[num]) {
                answer++;
            }
        }
        return answer;
    }
    
    void generatePermutations(String current, char[] numbers, boolean[] used, Set<Integer> numberSet) {
        if (!current.isEmpty()) {
            numberSet.add(Integer.parseInt(current));
        }
        for (int i = 0; i < numbers.length; i++) {
            if (!used[i]) {
                used[i] = true;
                generatePermutations(current + numbers[i], numbers, used, numberSet);
                used[i] = false;
            }
        }
    }

    boolean[] sieveOfEratosthenes(int max) {
        boolean[] prime = new boolean[max + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int p = 2; p * p <= max; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= max; i += p) {
                    prime[i] = false;
                }
            }
        }
        return prime;
    }
}
