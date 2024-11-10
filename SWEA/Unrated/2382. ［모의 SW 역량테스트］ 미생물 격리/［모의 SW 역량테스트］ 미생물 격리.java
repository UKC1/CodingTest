import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Micro {
        int id;
        int x;
        int y;
        int cnt;
        int dir;
        Micro(int id, int x, int y, int cnt, int dir) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dir = dir;
        }

        @Override
        public String toString() {
            return "Micro{" +
                    "id=" + id +
                    ", x=" + x +
                    ", y=" + y +
                    ", cnt=" + cnt +
                    ", dir=" + dir +
                    '}';
        }
    }
    static Map<Integer, int[]> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        map = new HashMap<>();
        map.put(1, new int[] {-1, 0});
        map.put(2, new int[] {1, 0});
        map.put(3, new int[] {0, -1});
        map.put(4, new int[] {0, 1});

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] maps;
            List<Micro> micros = new ArrayList<>();
            for (int id = 1; id <= K; id++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                micros.add(new Micro(id, x, y, cnt, dir));
            }

            int time = 0;
            while(time < M) {
                // 미생물 이동 시키기
                int size = micros.size();
                for (int i = 0; i < size; i++) {
                    Micro micro = micros.get(i);
                    int nx = micro.x + map.get(micro.dir)[0];
                    int ny = micro.y + map.get(micro.dir)[1];

                    // 경계선에 닿으면 반대방향으로 바꿔주고 cnt 반감
                    if (nx == 0 || ny == 0 || nx == N - 1 || ny == N - 1) {
                        int newDir = micro.dir % 2 == 0 ? micro.dir - 1 : micro.dir + 1;
                        int newCnt = micro.cnt / 2;
                        micros.get(i).x = nx;
                        micros.get(i).y = ny;
                        micros.get(i).cnt = newCnt;
                        micros.get(i).dir = newDir;
                    } else if (nx > 0 && nx < N - 1 && ny > 0 && ny < N - 1) {
                        micros.get(i).x = nx;
                        micros.get(i).y = ny;
                    }
                }
                maps = new int[N][N];
                // 겹치는 미생물 합쳐주기
                List<Integer> removeList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    Micro currMicro = micros.get(i);
                    if (maps[currMicro.x][currMicro.y] != 0) {
                        // 기존에 있는 경우 큰 놈으로 비교
                        int existId = maps[currMicro.x][currMicro.y];
                        Micro existMicro = null;
                        int currentListIdx = i;
                        int existListIdx = 0;
                        for (int idx = 0; idx < size; idx++) {
                            if (micros.get(idx).id == existId) {
                                existMicro = micros.get(idx);
                                existListIdx = idx;
                                break;
                            }
                        }

                        if (existMicro.cnt > currMicro.cnt) {
                            // 지금 군집 삭제
                            maps[currMicro.x][currMicro.y] = existMicro.id;
                            removeList.add(currMicro.id);
                        } else {
                            // 기존 군집 삭제
                            maps[currMicro.x][currMicro.y] = currMicro.id;
                            removeList.add(existMicro.id);
                        }
                    } else {
                        maps[currMicro.x][currMicro.y] = currMicro.id;
                    }
                }
                for (Integer removeId : removeList) {
                    Micro removeMicro = null;
                    for (Micro micro : micros) {
                        if (micro.id == removeId) {
                            removeMicro = micro;
                            break;
                        }
                    }
                    
                    int resultIdx = -1;
                    for (int idx = 0; idx < size; idx++) {
                        if (maps[removeMicro.x][removeMicro.y] == micros.get(idx).id) {
                            resultIdx = idx;
                            break;
                        }
                    }
                    micros.get(resultIdx).cnt += removeMicro.cnt;
                    micros.remove(removeMicro);
                }

                removeList.clear();
                time++;
            }

            int cnt = 0;
            for (Micro micro : micros) {
                cnt += micro.cnt;
            }
            sb.append('#').append(test_case).append(' ').append(cnt).append('\n');
        }
        System.out.print(sb);
    }
}