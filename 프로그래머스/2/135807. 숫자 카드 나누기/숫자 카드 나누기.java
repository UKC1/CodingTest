class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        /*
        1. 체크
        arrayA를 다 나누고
        arrayB를 다 나눌 수 없는 수
        Max는 arrayA의 최대 공약수
        
        arrayB를 다 나누고
        arrayA를 다 나눌 수 없는 수
        Max는 arrayB의 최대 공약수
        */
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }
        
        for (int i = 1; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);   
        }
        
        
        boolean isValidA = true;
        for (int i = 0; i < arrayB.length; i++) {
            if (arrayB[i] % gcdA == 0) {
                isValidA = false;
                break;
            }
        }
        
        boolean isValidB = true;
        for (int i = 0; i < arrayB.length; i++) {
            if (arrayA[i] % gcdB == 0) {
                isValidB = false;
                break;
            }
        }
        
        if (isValidB && isValidA) {
            answer = Math.max(gcdA, gcdB);
        } else {
            if (isValidA) {
                answer = gcdA;
            } else if (isValidB) {
                answer = gcdB;
            }
        }
        return answer;
    }
    
    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}