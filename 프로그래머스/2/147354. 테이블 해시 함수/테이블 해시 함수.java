import java.util.*;

class Solution {
    class Data {
        int idx;
        int first;
        int second;
        Data(int idx, int first, int second) {
            this.idx = idx;
            this.first = first;
            this.second = second;
        }
        
        public int getFirst() {
            return this.first;
        }
        
        public int getSecond() {
            return this.second;
        }
        
        public int getIdx() {
            return this.idx;
        }
        @Override
        public String toString() {
            return this.idx + " : " + this.first + " : " + this.second;
        }
    }
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        List<Data> list = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            list.add(new Data(i, data[i][col - 1], data[i][0]));
        }
        list.sort(Comparator.comparingInt(Data::getFirst)
                         .thenComparing(Comparator.comparingInt(Data::getSecond).reversed()));
        int[] tupleSumArr = new int[row_end - row_begin + 1];
        int idx = 0;
        for (int i = row_begin - 1; i < row_end; i++) {
            int sum = 0;
            int r = i + 1;
            for (int value : data[list.get(i).getIdx()]) {
                sum += value % r;
            }
            tupleSumArr[idx++] = sum;
        }
        
        int answer = tupleSumArr[0];
        for (int i = 1; i < tupleSumArr.length; i++) {
            answer ^= tupleSumArr[i];
        }
        return answer;
    }
}