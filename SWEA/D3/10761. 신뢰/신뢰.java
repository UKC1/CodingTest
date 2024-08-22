import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            Queue<Integer> queueB = new ArrayDeque<>();
            Queue<Integer> queueO = new ArrayDeque<>();
            char[] order = new char[N];

            for (int i = 0; i < N; i++) {
                char c = st.nextToken().charAt(0);
                order[i] = c;
                int num = Integer.parseInt(st.nextToken());
                if (c == 'B') queueB.offer(num);
                else if (c == 'O') queueO.offer(num);
            }
            int B = 1;
            int O = 1;
            int totalCnt = 0;
            boolean pressB = false;
            boolean pressO = false;
            for (int i = 0; i < order.length; i++) {
                if (order[i] == 'B') {
                    int numB = queueB.poll();
                    while (true) {
                        if (B < numB) {
                            B++;
                        } else if (B > numB) {
                            B--;
                        } else if (B == numB) {
                            pressB = true;
                        }
                        if(!queueO.isEmpty()) {
                            if (O < queueO.peek()) {
                                O++;
                            } else if (O > queueO.peek()) {
                                O--;
                            }
                        }
                        totalCnt++;
                        if (pressB) {
                            pressB = false;
                            break;
                        }
                    }
                } else if (order[i] == 'O') {
                    int numO = queueO.poll();
                    while (true) {
                        if (O < numO) {
                            O++;
                        } else if (O > numO) {
                            O--;
                        } else if (O == numO) {
                            pressO = true;
                        }
                        if(!queueB.isEmpty()) {
                            if (B < queueB.peek()) {
                                B++;
                            } else if (B > queueB.peek()) {
                                B--;
                            }
                        }
                        totalCnt++;
                        if (pressO) {
                            pressO = false;
                            break;
                        }
                    }
                }
            }
            sb.append("#").append(test_case).append(" ").append(totalCnt).append("\n");
        }

        System.out.print(sb);
    }

}