class Solution {
    public int[] solution(int[] arr, int[] query) {
        
        int start = 0;
        int end = 0;
    
        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                end = start + query[i];
            } else {
                start += query[i];
            }
        }
        
        int[] part = new int[end - start + 1];
        for (int i = 0; i < part.length; i++) {
            part[i] = arr[i + start];
        }
        

        return part;
    }
}