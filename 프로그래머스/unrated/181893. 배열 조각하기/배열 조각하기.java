class Solution {
    public int[] solution(int[] arr, int[] query) {
        
        int start = -1;
        int end = -1;
    
        // idx 초기화
        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                if (end == -1) {
                    end = query[i];
                } else {
                    end = start + query[i];
                    
                }
            } else {
                if (start == -1) {
                    start = query[i];
                } else {
                    start += query[i];
                }
            }
            System.out.println(start + " " + end);
        }
        
        int[] part = new int[end - start + 1];
        for (int i = 0; i < part.length; i++) {
            part[i] = arr[i + start];
        }
        

        return part;
    }
}