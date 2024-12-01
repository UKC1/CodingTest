class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2]; // 0의 개수와 1의 개수
        quadTree(arr, 0, 0, arr.length, answer);
        return answer;
    }

    // 쿼드 트리 탐색 함수
    private void quadTree(int[][] arr, int x, int y, int size, int[] answer) {
        // 현재 영역이 모두 같은 숫자인지 확인
        if (isUniform(arr, x, y, size)) {
            if (arr[x][y] == 0) {
                answer[0]++; // 0의 개수 증가
            } else {
                answer[1]++; // 1의 개수 증가
            }
            return;
        }

        // 영역을 4분할하여 재귀적으로 탐색
        int newSize = size / 2;
        quadTree(arr, x, y, newSize, answer); // 1사분면
        quadTree(arr, x, y + newSize, newSize, answer); // 2사분면
        quadTree(arr, x + newSize, y, newSize, answer); // 3사분면
        quadTree(arr, x + newSize, y + newSize, newSize, answer); // 4사분면
    }

    // 현재 영역이 모두 같은 숫자인지 확인하는 함수
    private boolean isUniform(int[][] arr, int x, int y, int size) {
        int firstNum = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != firstNum) {
                    return false;
                }
            }
        }
        return true;
    }
}
