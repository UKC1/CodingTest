import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String winner = st.nextToken();
                int winnerMoney = Integer.parseInt(st.nextToken());
                map.put(winner, winnerMoney);
            }

            int totalMoney = 0;
            for (int i = 0; i < M; i++) {
                String myLotto = br.readLine();
                for (String winner : map.keySet()) {
                    boolean isWinner = true;
                    for (int j = 0; j < winner.length(); j++) {
                        char win = winner.charAt(j);
                        char myLot = myLotto.charAt(j);
                        if (win != '*' && myLot != win) {
                            isWinner = false;
                            break;
                        }
                    }

                    if (isWinner) {
                        totalMoney += map.get(winner);
                    }
                }
            }

            sb.append("#").append(test_case).append(" ").append(totalMoney).append("\n");
        }
        System.out.print(sb);
    }
}