import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] cntArr = new int[8001];
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        int maxCntNum = 0;
        int maxCnt = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            arr[i] = num;
            cntArr[num + 4000]++;
            if (maxCnt < cntArr[num + 4000]) {
                maxCnt = cntArr[num + 4000];
            }
        }
        Arrays.sort(arr);

        for (int i = 0; i < cntArr.length; i++) {
            if (cntArr[i] == maxCnt) {
                list.add(i - 4000);
                if (list.size() > 1) break;
            }
        }

        if (list.size() > 1) {
            maxCntNum = list.get(1);
        } else {
            maxCntNum = list.get(0);
        }
        System.out.println((int)Math.round((double)sum / N));
        System.out.println(arr[N / 2]);
        System.out.println(maxCntNum);
        System.out.println(arr[arr.length - 1] - arr[0]);
    }
}