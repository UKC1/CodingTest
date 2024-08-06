import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        map.put("0001101", 0);
        map.put("0011001", 1);
        map.put("0010011", 2);
        map.put("0111101", 3);
        map.put("0100011", 4);
        map.put("0110001", 5);
        map.put("0101111", 6);
        map.put("0111011", 7);
        map.put("0110111", 8);
        map.put("0001011", 9);

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            char[][] arr = new char[N][M];
            for (int i = 0; i < N; i++) {
                arr[i] = br.readLine().toCharArray();
            }

            int x = 0;
            loop: for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == '1') {
                        x = i;
                        break loop;
                    }
                }
            }
            int y = 0;
            int[] check = new int[8];
            int cnt = 0;
            checkLoop: for (int i = 0; i <= M - 7; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 7; j++) {
                    sb.append(arr[x][i + j]);
                    if (map.containsKey(sb.toString())) {
                        // 시작 y값
                        y = i + j - 6;
                        boolean isTrue = true;
                        for (int k = 0; k <= 49; k+=7) {
                            StringBuilder checkSb = new StringBuilder();
                            for (int l = y; l < y + 7; l++) {
                                checkSb.append(arr[x][l + k]);
                            }
                            if(!map.containsKey(checkSb.toString())) {
                                isTrue = false;
                                break;
                            }
                        }
                        if (isTrue) break checkLoop;
                    }
                }
            }
            for (int i = y; i <= y + 49 ; i += 7) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 7; j++) {
                    sb.append(arr[x][i + j]);
                }
                check[cnt++] = map.get(sb.toString());
            }



            int sum = 0;
            int evenSum = 0;
            for (int i = 0; i < check.length; i++) {
                if (i % 2 == 0) {
                    evenSum += check[i] * 2;
                }
                sum += check[i];
            }
            System.out.println("#" + test_case + " " + ((sum + evenSum) % 10 == 0 ? sum : 0));
        }
    }
}