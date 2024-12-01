class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        quadTree(arr, 0, 0, arr.length, answer);
        return answer;
    }
    
    public void quadTree(int[][] arr, int x, int y, int size, int[] answer) {
        if (isUniform(arr, x, y, size)) {
            int num = arr[x][y];
            if (num == 0) {
                answer[0]++;
            } else {
                answer[1]++;
            }
            return;
        }
        
        size /= 2;
        quadTree(arr, x, y, size, answer); 
        quadTree(arr, x, y + size, size, answer); 
        quadTree(arr, x + size, y + size, size, answer); 
        quadTree(arr, x + size, y, size, answer); 
    }
    
    public boolean isUniform(int[][] arr, int x, int y, int size) {
        int first = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != first) {
                    return false;
                }
            }
        }
        return true;
    }
}