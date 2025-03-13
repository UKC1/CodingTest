import java.util.*;

class Solution {
    Map<Integer, Map<String, Integer>> check;
    int[] cnt;
    
    class Word implements Comparable<Word> {
        String word;
        int cnt;
        
        Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(Word o) {
            return this.word.compareTo(o.word); // 사전순 정렬
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        check = new HashMap<>();
        cnt = new int[26];
        
        for (String order : orders) {
            char[] orderArr = order.toCharArray();
            Arrays.sort(orderArr); // 정렬하여 사전순 조합 생성
            
            for (char c : orderArr) {
                cnt[c - 'A']++;
            }
            
            for (int r : course) {
                if (r > orderArr.length) continue;
                combination(orderArr, r, new StringBuilder(), 0);
            }
        }
        
        PriorityQueue<Word> pq = new PriorityQueue<>();
        
        for (int r : course) {
            if (!check.containsKey(r)) continue;
            
            int maxCnt = 2;
            List<Word> tmp = new ArrayList<>();
            
            for (Map.Entry<String, Integer> entry : check.get(r).entrySet()) {
                int count = entry.getValue();
                if (count >= maxCnt) {
                    if (count > maxCnt) {
                        tmp.clear();
                        maxCnt = count;
                    }
                    tmp.add(new Word(entry.getKey(), count));
                }
            }
            pq.addAll(tmp); // 우선순위 큐에 추가
        }
        
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll().word);
        }
        
        return result.toArray(new String[0]);
    }
    
    void combination(char[] orderArr, int r, StringBuilder current, int start) {
        if (current.length() == r) {
            String comb = current.toString();
            check.putIfAbsent(r, new HashMap<>());
            check.get(r).put(comb, check.get(r).getOrDefault(comb, 0) + 1);
            return;
        }
        
        for (int i = start; i < orderArr.length; i++) {
            current.append(orderArr[i]);
            combination(orderArr, r, current, i + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
