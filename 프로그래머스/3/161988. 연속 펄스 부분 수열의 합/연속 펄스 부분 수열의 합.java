class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        long[] pulse1 = new long[n];
        long[] pulse2 = new long[n];

        for (int i = 0; i < n; i++) {
            int sign = (i % 2 == 0) ? 1 : -1;
            pulse1[i] = sequence[i] * sign;
            pulse2[i] = sequence[i] * -sign;
        }

        return Math.max(getMaxSubArray(pulse1), getMaxSubArray(pulse2));
    }
    
    private long getMaxSubArray(long[] arr) {
        long max = arr[0];
        long sum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            sum = Math.max(arr[i], sum + arr[i]);
            max = Math.max(max, sum);
        }

        return max;
    }
}