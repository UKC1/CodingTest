import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] count = new int[8001]; // -4000 ~ 4000 범위의 값을 카운팅하기 위한 배열
        int sum = 0;
        int maxFreq = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            arr[i] = num;
            count[num + 4000]++; // -4000 ~ 4000 범위를 0 ~ 8000으로 변환하여 카운팅
            maxFreq = Math.max(maxFreq, count[num + 4000]); // 최빈값의 빈도수 저장
        }

        Arrays.sort(arr);

        // 산술 평균
        System.out.println((int)Math.round((double)sum / N));

        // 중앙값
        System.out.println(arr[N / 2]);

        // 최빈값 계산
        ArrayList<Integer> modeList = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (count[i] == maxFreq) {
                modeList.add(i - 4000); // 저장된 인덱스를 원래 값으로 변환
            }
        }

        // 최빈값 출력 (최빈값이 여러 개 있을 경우 두 번째로 작은 값 출력)
        if (modeList.size() > 1) {
            System.out.println(modeList.get(1));
        } else {
            System.out.println(modeList.get(0));
        }

        // 범위 출력
        System.out.println(arr[N - 1] - arr[0]);
    }
}