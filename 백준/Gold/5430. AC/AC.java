import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int test = 0; test < T; test++) {
            char[] commands = br.readLine().toCharArray();
            int arrSize = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            
            // 배열 입력 처리
            int[] nums = new int[arrSize];
            if (arrSize > 0) {
                arr = arr.substring(1, arr.length() - 1);
                StringTokenizer st = new StringTokenizer(arr, ",");
                for (int i = 0; i < arrSize; i++) {
                    nums[i] = Integer.parseInt(st.nextToken());
                }
            }

            boolean isReversed = false;
            boolean isError = false;
            int left = 0;
            int right = arrSize - 1;

            // 명령어 처리
            for (char command : commands) {
                if (command == 'R') {
                    isReversed = !isReversed;
                } else if (command == 'D') {
                    if (left > right) { // 배열이 비어있을 때
                        isError = true;
                        sb.append("error\n");
                        break;
                    }
                    if (isReversed) {
                        right--; // 뒤집힌 상태에서는 뒤에서 제거
                    } else {
                        left++; // 정상 상태에서는 앞에서 제거
                    }
                }
            }

            // 결과 출력
            if (!isError) {
                sb.append("[");
                if (isReversed) {
                    for (int i = right; i >= left; i--) {
                        sb.append(nums[i]);
                        if (i != left) sb.append(",");
                    }
                } else {
                    for (int i = left; i <= right; i++) {
                        sb.append(nums[i]);
                        if (i != right) sb.append(",");
                    }
                }
                sb.append("]\n");
            }
        }
        
        System.out.print(sb);
    }
}