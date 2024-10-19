import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // LIS (왼쪽에서 오른쪽으로 증가하는 부분 수열)
        int[] lis = new int[N];
        for (int i = 0; i < N; i++) {
            lis[i] = 1;  // 자기 자신만 있는 경우 최소 길이 1
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // LDS (오른쪽에서 왼쪽으로 감소하는 부분 수열)
        int[] lds = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            lds[i] = 1;  // 자기 자신만 있는 경우 최소 길이 1
            for (int j = N - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        // 가장 긴 바이토닉 부분 수열의 길이 구하기
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            maxLen = Math.max(maxLen, lis[i] + lds[i] - 1);
        }

        System.out.println(maxLen);
    }
}