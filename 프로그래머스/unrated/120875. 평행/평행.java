class Solution {
    public int solution(int[][] dots) {
        int index = 0;
        if (
            calculateSlope(dots[0], dots[1]) == calculateSlope(dots[2], dots[3])
            ) {
            return 1;
        } else if (
            calculateSlope(dots[0], dots[2]) == calculateSlope(dots[1], dots[3])
        ) {
            return 1;
        } else if (
            calculateSlope(dots[0], dots[3]) == calculateSlope(dots[1], dots[2])
        ) {
            return 1;
        }
        return 0;
    }

    private double calculateSlope(int[] dot1, int[] dot2) {
        double dy = dot2[1] - dot1[1];
        double dx = dot2[0] - dot1[0];
        return dy / dx;
    }
}
