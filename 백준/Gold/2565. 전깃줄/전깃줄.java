import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] lines = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken()); // A 위치
            lines[i][1] = Integer.parseInt(st.nextToken()); // B 위치
        }

        // A 위치를 기준으로 오름차순 정렬
        Arrays.sort(lines, Comparator.comparingInt(o -> o[0]));

        // 가장 긴 증가하는 부분 수열(LIS)을 B 위치에서 구함
        int[] lis = new int[N];
        int lisLength = 0;

        for (int i = 0; i < N; i++) {
            int b = lines[i][1];

            // LIS에서 이분 탐색을 사용하여 위치를 찾음
            int pos = Arrays.binarySearch(lis, 0, lisLength, b);
            if (pos < 0) {
                pos = -(pos + 1); // 삽입 위치
            }
            lis[pos] = b;
            if (pos == lisLength) {
                lisLength++;
            }
        }

        // 최소로 끊어야 하는 전깃줄의 개수 = 전체 전깃줄 개수 - LIS 길이
        System.out.println(N - lisLength);
    }
}