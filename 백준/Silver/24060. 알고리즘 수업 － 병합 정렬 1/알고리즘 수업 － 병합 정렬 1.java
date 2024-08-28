import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cnt = 0;
    static int K;
    static int num;
    static boolean found = false; // 추가: K번째 요소를 찾았는지 여부를 추적

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(arr, 0, arr.length - 1);
        System.out.print(cnt < K ? -1 : num);
    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left < right && !found) { // 최적화: 요소를 찾은 경우 더 이상 재귀 호출을 하지 않음
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            cnt++;
            if (cnt == K) {
                num = arr[k];
                found = true; // K번째 요소를 찾았음을 표시
                return; // 최적화: K번째 요소를 찾으면 바로 리턴
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            cnt++;
            if (cnt == K) {
                num = arr[k];
                found = true; // K번째 요소를 찾았음을 표시
                return; // 최적화: K번째 요소를 찾으면 바로 리턴
            }
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            cnt++;
            if (cnt == K) {
                num = arr[k];
                found = true; // K번째 요소를 찾았음을 표시
                return; // 최적화: K번째 요소를 찾으면 바로 리턴
            }
            j++;
            k++;
        }
    }
}