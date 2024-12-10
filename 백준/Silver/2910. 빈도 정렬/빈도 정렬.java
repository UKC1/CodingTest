import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Sequence {
        int num;
        int createdAt;
        int totalCnt;
        Sequence(int num, int createdAt, int totalCnt) {
            this.num = num;
            this.createdAt = createdAt;
            this.totalCnt = totalCnt;
        }

        public int getNum() {
            return num;
        }

        public int getCreatedAt() {
            return createdAt;
        }

        public int getTotalCnt() {
            return totalCnt;
        }

        @Override
        public String toString() {
            return "Sequence{" +
                    "num=" + num +
                    ", createdAt=" + createdAt +
                    ", totalCnt=" + totalCnt +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (map.containsKey(num)) {
                map.get(num)[1]++;
            } else {
                map.put(num, new int[]{i, 1});
            }
        }

        List<Sequence> list = new ArrayList<>();
        for (Integer num : map.keySet()) {
            list.add(new Sequence(num, map.get(num)[0], map.get(num)[1]));
        }
        list.sort(Comparator.comparingInt(Sequence::getTotalCnt).reversed().thenComparingInt(Sequence::getCreatedAt));
        for (Sequence s : list) {
            for (int i = 0; i < s.totalCnt; i++) {
                sb.append(s.num).append(' ');
            }
        }
        System.out.println(sb);
    }
}