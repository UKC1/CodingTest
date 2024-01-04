import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(int N, int[] stages) {
       Arrays.sort(stages);
       double[] arr = new double[N];
       int[] answer = new int[N];
        
        for (int i = 0; i < stages.length; i++) {
            if (stages[i] > N) {
                continue;
            } else {
                arr[stages[i] - 1] ++;
            }
        }
        
        ArrayList<Double> list = new ArrayList<>();
        double n = stages.length;
        double ck = 0;
        for (int i = 0; i < arr.length; i++) {
            ck = arr[i];
            
            arr[i] = arr[i] / n;
            list.add(arr[i]);
            if (n - ck > 0) {
                n -= ck;
            }      
        }
        
       
        double[] arrSorted = new double[N];
        System.arraycopy(arr, 0, arrSorted, 0, arr.length);
        Arrays.sort(arrSorted);
        System.out.println(Arrays.toString(arrSorted)); 
        System.out.println(Arrays.toString(arr));
        

        for (int i = 0; i < arr.length; i++) {
            double max = arrSorted[arr.length - 1 - i];
            for (int j = 0; j < list.size(); j++) {
                if (max == list.get(j)) {
                    answer[i] = j + 1;
              
                    list.set(j, -1.0);
                    break;
                }
            }
        }

        return answer;
    }
}