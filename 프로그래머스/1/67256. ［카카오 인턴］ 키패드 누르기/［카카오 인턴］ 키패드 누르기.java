class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int[] left = {3, 0};
        int[] right = {3, 2};
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7 ) {
                left[0] = (numbers[i] - 1) / 3;
                left[1] = 0;
                sb.append("L");
            } else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                right[0] = numbers[i] / 3 - 1;
                right[1] = 2;
                sb.append("R");
            } else {
                if (numbers[i] == 0) {
                    numbers[i] = 10;
                }
                int leftDist = Math.abs(1 - left[1]) + Math.abs(left[0] - numbers[i] / 3);
                int rightDist = Math.abs(right[1] - 1) + Math.abs(right[0] - numbers[i] / 3);
                if (leftDist > rightDist) {
                    sb.append("R");
                    right[0] = numbers[i] / 3;
                    right[1] = 1;
                } else if (leftDist < rightDist) {
                    sb.append("L");
                    left[0] = numbers[i] / 3;
                    left[1] = 1;
                } else {
                    if (hand.equals("right")) {
                        sb.append("R");
                        right[0] = numbers[i] / 3;
                        right[1] = 1;
                    } else {
                        sb.append("L");
                        left[0] = numbers[i] / 3;
                        left[1] = 1;
                    }
                }
                
            }
        }
        return sb.toString();
    }
}