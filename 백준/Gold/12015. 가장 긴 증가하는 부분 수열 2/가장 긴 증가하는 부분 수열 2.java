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
                // 가장 큰 값보다 크면 뒤에 추가
                list.add(num);
            } else {
                // 이진 탐색을 통해 적절한 위치 찾기
                int pos = Collections.binarySearch(list, num);
                if (pos < 0) {
                    pos = -(pos + 1); // 삽입 위치
                }
                list.set(pos, num); // 해당 위치 값 교체
            }
        }

        System.out.println(list.size()); // LIS 길이 출력
    }
}