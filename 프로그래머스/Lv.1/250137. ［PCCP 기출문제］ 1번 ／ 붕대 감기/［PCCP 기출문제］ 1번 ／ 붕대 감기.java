class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int cnt = 0;
        int start = 0;
        int idx = 0;
        int fullHp = health;
        
        while(idx < attacks.length) {
            for (int i = start; i < attacks[idx][0]; i++) {
               
                health = health + bandage[1] <= fullHp ? health + bandage[1] : fullHp;
                cnt++;
                if (cnt == bandage[0]) {
                    health = health + bandage[2] <= fullHp ? health + bandage[2] : fullHp;
                    cnt = 0;
                }
            } 
            start = attacks[idx][0] + 1;
            health -= attacks[idx][1];
            idx++;
            cnt = 0;
            if (health <= 0) {
                return -1;
            }
        }
        return health;
    }
}