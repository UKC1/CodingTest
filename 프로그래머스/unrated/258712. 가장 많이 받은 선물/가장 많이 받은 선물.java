import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> map = new HashMap();
        int[] giftIdx = new int[friends.length];
        int[] getGift = new int[friends.length];
        
        for(int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }
        
        int[][] arr = new int[friends.length][friends.length];
        
        for (int i = 0; i < gifts.length; i++) {
            int post = map.get(gifts[i].split(" ")[0]);
            int get = map.get(gifts[i].split(" ")[1]);
            arr[post][get]++;
        }
    
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                giftIdx[i] += arr[i][j];
                giftIdx[i] -= arr[j][i];
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
               if(arr[i][j] > arr[j][i]) {
                   getGift[i]++;
               } else if(i != j && arr[i][j] == arr[j][i]) {
                   if(giftIdx[i] > giftIdx[j]) {
                       getGift[i]++;
                   } 
               }
            }
        }
        Arrays.sort(getGift);
        return getGift[getGift.length - 1];
    }
}