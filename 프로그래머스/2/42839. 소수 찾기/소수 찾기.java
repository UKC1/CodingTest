import java.util.*;

class Solution {
    public int solution(String numbers) {
        // 숫자 조합을 저장할 Set
        Set<Integer> set = new HashSet<>();
        // 주어진 숫자를 char 배열로 변환
        char[] arr = numbers.toCharArray();
        // 방문 여부를 확인할 배열
        boolean[] visited = new boolean[arr.length];
        
        // 모든 조합 생성
        generateCombinations(arr, visited, set, new StringBuilder());
        
        // 생성된 조합 중 최대값 찾기
        int maxNum = Collections.max(set);
        // 에라토스테네스의 체를 사용하여 소수 판별
        boolean[] isPrime = sieveOfEratosthenes(maxNum);
        
        // 소수 개수 카운트
        int cnt = 0;
        for (int num : set) {
            if (isPrime[num]) cnt++;
        }
        return cnt;
    }

    private void generateCombinations(char[] arr, boolean[] visited, Set<Integer> set, StringBuilder current) {
        if (current.length() > 0) {
            set.add(Integer.parseInt(current.toString()));
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.append(arr[i]);
                generateCombinations(arr, visited, set, current);
                current.deleteCharAt(current.length() - 1);
                visited[i] = false;
            }
        }
    }

    private boolean[] sieveOfEratosthenes(int maxNum) {
        boolean[] isPrime = new boolean[maxNum + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= maxNum; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= maxNum; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
