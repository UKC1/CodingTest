import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]); // 첫 번째 원소 추가

        for (int i = 1; i < N; i++) {
            int num = arr[i];
            if (num > list.get(list.size() - 1)) {
                list.add(num); // 가장 큰 값이면 추가
            } else {
                int pos = lowerBound(list, num); // 이진 탐색 직접 구현
                list.set(pos, num); // 적절한 위치의 값 교체
            }
        }

        System.out.println(list.size()); // LIS 길이 출력
    }

    // lowerBound: 이진 탐색으로 num이 들어갈 위치 찾기
    static int lowerBound(ArrayList<Integer> list, int key) {
        int left = 0, right = list.size() - 1;
        
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (list.get(mid) >= key) {
                right = mid; // 왼쪽으로 탐색
            } else {
                left = mid + 1; // 오른쪽으로 탐색
            }
        }
        
        return right; // key가 들어갈 위치 반환
    }
}