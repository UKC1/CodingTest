class Solution {
    public int solution(int a, int b) {
        int answer = 1;
        b = b / gcd(a,b);
        while(b > 0) {
            if (b % 10 == 0) {
                b /= 10;
            } else if (b % 5 == 0) {
                b /= 5;
            } else if (b % 2 == 0) {
                b /= 2;
            } else if(b == 1) {
                break;
            } else {
                answer = 2;
                break;
            }
        }
        System.out.println(b);
        return answer;
    }
    
    // 1. 기약 분수로 만들자
    // public int gcd (int n, int m) {
    //     int tmp = 0;
    //     while(n > 0) {
    //         if (m % n == 0) {
    //             break;
    //         }
    //         tmp = n;
    //         n = m;
    //         m = tmp % m;
    //     }
    //     return n;
    // }
    public int gcd (int n, int m) {
        if (m % n == 0) {
            return n;
        }
        return gcd(m, n % m);
    }
    
    // 2. 2, 5로 구성되어 있는지 체크
    
    
    
    
}