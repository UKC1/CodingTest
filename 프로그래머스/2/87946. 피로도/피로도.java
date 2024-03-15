import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        List<List<Integer>> permutations = new ArrayList<>();
        permute(permutations, new ArrayList<>(), dungeons.length);

        int maxDungeons = 0;
        for (List<Integer> perm : permutations) {
            int fatigue = k;
            int count = 0;
            for (int i : perm) {
                if (fatigue >= dungeons[i][0]) {
                    fatigue -= dungeons[i][1];
                    count++;
                } else {
                    break;
                }
            }
            maxDungeons = Math.max(maxDungeons, count);
        }
        return maxDungeons;
    }
    
    public void permute(List<List<Integer>> permutations, List<Integer> temp, int n) {
        if (temp.size() == n) {
            permutations.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (temp.contains(i)) continue;
            temp.add(i);
            permute(permutations, temp, n);
            temp.remove(temp.size() - 1);
        }
    }
}