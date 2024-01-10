import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        ArrayList<int[]> list = new ArrayList();
        ArrayList<Integer> sortIdx = new ArrayList();
        
        HashMap<String, Integer> map = new HashMap();
        String[] str = {"code", "date", "maximum", "remain"};
        for (int i = 0; i < str.length; i++) {
            map.put(str[i], i);
        }
        
        int extNum = map.get(ext);
        int sortNum = map.get(sort_by);
        for (int i = 0; i < data.length; i++) {
            if (data[i][extNum] < val_ext) {
                list.add(data[i]);
                sortIdx.add(data[i][sortNum]);
            }
        }
        
        int[][] answer = new int[list.size()][data[0].length];
        Collections.sort(sortIdx);
        
        for (int i = 0; i < sortIdx.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (sortIdx.get(i) == list.get(j)[sortNum]) {
                    for (int k = 0; k < answer[i].length; k++) {
                        answer[i][k] = list.get(j)[k]; 
                    }
                    list.get(j)[sortNum] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}