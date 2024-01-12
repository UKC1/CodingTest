import java.util.HashMap;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> map = new HashMap<>();
        int[] giftIdx = new int[friends.length];
        int maxGifts = 0; // 최대 선물 횟수를 저장하는 변수

        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }

        int[][] arr = new int[friends.length][friends.length];

        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            int giver = map.get(parts[0]);
            int receiver = map.get(parts[1]);
            arr[giver][receiver]++;
        }

        for (int i = 0; i < arr.length; i++) {
            int giftsGiven = 0; // 현재 친구가 준 선물 수
            int giftsReceived = 0; // 현재 친구가 받은 선물 수
            for (int j = 0; j < arr.length; j++) {
                giftsGiven += arr[i][j];
                giftsReceived += arr[j][i];
            }
            giftIdx[i] = giftsGiven - giftsReceived;
        }

        for (int i = 0; i < arr.length; i++) {
            int currentGifts = 0; // 현재 친구의 선물 횟수
            for (int j = 0; j < arr.length; j++) {
                if (i != j && (arr[i][j] > arr[j][i] || (arr[i][j] == arr[j][i] && giftIdx[i] > giftIdx[j]))) {
                    currentGifts++;
                }
            }
            maxGifts = Math.max(maxGifts, currentGifts); // 최대 선물 횟수 갱신
        }

        return maxGifts;
    }
}
