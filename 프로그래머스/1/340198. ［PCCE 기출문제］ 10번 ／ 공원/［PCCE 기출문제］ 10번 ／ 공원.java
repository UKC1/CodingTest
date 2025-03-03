class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        for (int mat : mats) {
            for (int i = 0; i <= park.length - mat; i++) {
                for (int j = 0; j <= park[i].length - mat; j++) {
                    boolean canSit = true;
                    loop : for (int x = i; x < i + mat; x++) {
                        for (int y = j; y < j + mat; y++) { 
                            if (!park[x][y].equals("-1")) {
                                canSit = false;
                                break loop;    
                            }
                        }
                    }
                    
                    if (canSit) {
                        answer = Math.max(answer, mat);
                    }
                }
            }
        }
        return answer;
    }
}