import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);

        int count = 0;
        for (int number : set) {
            if (isPrime(number)) {
                count++;
            }
        }
        return count;
    }

    private void permutation(String prefix, String str, Set<Integer> set) {
        int n = str.length();
        if (!prefix.isEmpty()) {
            set.add(Integer.parseInt(prefix));
        }
        for (int i = 0; i < n; i++) {
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);
        }
    }

    private boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
