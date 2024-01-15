class Solution {
    public int[] solution(int brown, int yellow) {
        int totalArea = brown + yellow; // 전체 면적 계산

        for (int i = 1; i <= Math.sqrt(totalArea); i++) {
            if (totalArea % i == 0) {
                // 세로 길이
                int height = i;
                // 가로 길이
                int width = totalArea / i;

                // 갈색 타일의 수를 고려한 조건 확인
                if ((width - 2) * (height - 2) == yellow) {
                    return new int[] {width, height};
                }
            }
        }

        return new int[2]; // 조건에 맞는 카펫 크기를 찾지 못한 경우 빈 배열 반환
    }
}
