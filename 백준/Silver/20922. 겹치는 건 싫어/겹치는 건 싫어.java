import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[100001]; // 숫자의 등장 횟수 기록
        int left = 0, right = 0, maxLength = 0;

        while (right < N) {
            int current = numbers[right];

            if (count[current] < K) {
                count[current]++;
                right++;
                maxLength = Math.max(maxLength, right - left);
            } else {
                count[numbers[left]]--;
                left++;
            }
        }

        System.out.println(maxLength);
    }
}
