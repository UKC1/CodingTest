class Solution {
    public int[] solution(int[] answers) {
        
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == arr1[i % arr1.length]) {
                c1++;
            } 
            
            if (answers[i] == arr2[i % arr2.length]) {
                c2++;
            } 
            
            if (answers[i] == arr3[i % arr3.length]) {
                c3++;
            }
        }
        
        if (c1 == c2 && c2 == c3) {
            return new int[] {1, 2, 3};
        } else if (c1 == c2 && c2 > c3) {
            return new int[] {1, 2};
        } else if (c1 == c3 && c3 > c2) {
            return new int[] {1, 3};
        } else if (c2 == c3 && c3 > c1) {
            return new int[] {2, 3};
        } else {
            if (c1 > c2 && c1 > c3) {
                return new int[] {1};
            } else if (c2 > c1 && c2 > c3) {
                return new int[] {2};
            } else {
                return new int[] {3};
            }
        }
        
    }
}