import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 집의 개수
        int C = Integer.parseInt(st.nextToken()); // 공유기 개수
        int[] homes = new int[N]; // 집의 좌표

        // 집 좌표 입력
        for (int i = 0; i < N; i++) {
            homes[i] = Integer.parseInt(br.readLine());
        }

        // 좌표 정렬
        Arrays.sort(homes);

        // 이분 탐색을 위한 초기값 설정
        int left = 1; // 최소 간격
        int right = homes[N - 1] - homes[0]; // 최대 간격
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2; // 중간 간격
            int cnt = 1; // 첫 번째 집에는 무조건 공유기 설치
            int prev = homes[0]; // 첫 번째 공유기가 설치된 집의 위치

            // 각 집에 공유기 설치 가능 여부 확인
            for (int i = 1; i < N; i++) {
                if (homes[i] - prev >= mid) {
                    cnt++; // 공유기를 설치할 수 있는 집
                    prev = homes[i]; // 현재 공유기를 설치한 집을 갱신
                }
            }

            // 공유기 설치 개수가 목표 개수 이상일 경우 간격을 더 넓히기
            if (cnt >= C) {
                result = mid; // 가능한 최대 거리 갱신
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // 결과 출력
        System.out.print(result);
    }
}