class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow; // 전체 타일 수
        
        for (int width = 3; width <= Math.sqrt(total); width++) { // 너비는 최소 3부터 시작
            if (total % width == 0) { // 너비로 나누어 떨어지는 경우
                int length = total / width; // 길이 계산
                
                // 노란색 타일 면적이 맞는지 확인
                if ((width - 2) * (length - 2) == yellow) {
                    return new int[] {Math.max(width, length), Math.min(width, length)}; // 너비와 길이 반환
                }
            }
        }
        return new int[] {}; // 적절한 치수를 찾지 못한 경우
    }
}
