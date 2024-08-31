import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            List<Integer> lis = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {
                int num = arr[i];
                
                // num이 lis의 마지막 원소보다 크다면 추가
                if (lis.isEmpty() || lis.get(lis.size() - 1) < num) {
                    lis.add(num);
                } else {
                    // 그렇지 않다면, num이 들어갈 위치를 찾아 대체
                    int pos = Collections.binarySearch(lis, num);
                    if (pos < 0) pos = -(pos + 1); // binarySearch가 음수로 반환할 때 위치 계산
                    lis.set(pos, num);
                }
            }
            
            sb.append("#").append(test_case).append(" ").append(lis.size()).append("\n");
        }
        
        System.out.print(sb);
    }
}