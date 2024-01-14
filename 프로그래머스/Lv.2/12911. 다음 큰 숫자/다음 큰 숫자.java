class Solution {
    public int solution(int n) {
        String nToBinary = Integer.toString(n, 2);
        String nToBinaryOne = nToBinary.replace("1", "");
        int nLen = nToBinary.length() == nToBinaryOne.length() ? nToBinary.length() : nToBinary.length() - nToBinaryOne.length();
        
        int len = -1;
        while(nLen != len) {
            n++;
            nToBinary = Integer.toString(n, 2);
            nToBinaryOne = nToBinary.replace("1", "");
            len = nToBinary.length() == nToBinaryOne.length() ? nToBinary.length() : nToBinary.length() - nToBinaryOne.length();
       
        }
        return n;
    }
}