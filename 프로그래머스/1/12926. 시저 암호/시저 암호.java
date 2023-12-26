class Solution {
    public String solution(String s, int n) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                sb.append(arr[i]);
            } else if (arr[i] >= 'a') {
                sb.append((char) ((arr[i] - 'a' + n) % 26 + 'a'));
            } else if (arr[i] >= 'A') {
                sb.append((char) ((arr[i] - 'A' + n) % 26 + 'A'));
            }
           
        }
        System.out.println((int)'a' + " " + (int)'z');
        System.out.println((int)'A' + " " + (int)'Z');
        return sb.toString();
    }
}