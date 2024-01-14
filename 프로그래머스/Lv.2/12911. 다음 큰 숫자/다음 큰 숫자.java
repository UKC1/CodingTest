public class Solution {
    public int solution(int n) {
        int nOneCount = countOnesInBinary(n);

        do {
            n++;
        } while (countOnesInBinary(n) != nOneCount);

        return n;
    }

    private int countOnesInBinary(int number) {
        int count = 0;
        while (number > 0) {
            if ((number & 1) == 1) {
                count++;
            }
            number >>= 1; // 오른쪽으로 1비트 이동
        }
        return count;
    }
}

