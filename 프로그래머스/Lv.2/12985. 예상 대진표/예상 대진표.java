class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        while(Math.abs(a - b) > 0) {
            int ra = a % 2;
            int rb = b % 2;
            a /= 2;
            a += ra;
            b /= 2;
            b += rb;
            answer++;
        }

        return answer;
    }
}