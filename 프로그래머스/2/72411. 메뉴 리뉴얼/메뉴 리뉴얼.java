import java.util.*;
class Solution {
    List<Map<Set<Character>, Integer>> check;
    int[] cnt;
    class Word {
        String word;
        int cnt;
        
        Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
        
        String getWord() {
            return this.word;
        }
        
        int getCnt() {
            return this.cnt;
        }
        
        @Override
        public String toString() {
            return this.word + " : " + this.cnt;
        }
    }
    public String[] solution(String[] orders, int[] course) {
        check = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            check.add(new HashMap<>());
        }
       
        cnt = new int[26];
        List<Word> list = new ArrayList<>();
        for (int i = 0; i < orders.length; i++) {
            char[] orderArr = orders[i].toCharArray();
            int n = orderArr.length;
            for (int j = 0; j < n; j++) {
                cnt[orderArr[j] - 'A']++;
            }
            
            for (int r : course) {
                if (r > orderArr.length) continue;
                combination(orderArr, n, r, new ArrayList<>(), 0, 0);
            }
        }
        
        List<Word> tmp = new ArrayList<>();
        for (int r : course) {
            // 최대 빈도수 찾기
            int maxCnt = 0;
            for (Set<Character> comb : check.get(r).keySet()) {
                int courseCnt = check.get(r).get(comb);
                if (isValid(comb) && courseCnt > 1) {
                    if (courseCnt > maxCnt) {
                        tmp.clear();
                        String combStr = convertStr(comb);
                        tmp.add(new Word(combStr, courseCnt));
                        maxCnt = courseCnt;
                    } else if (courseCnt == maxCnt) {
                        String combStr = convertStr(comb);
                        tmp.add(new Word(combStr, courseCnt));
                    }
                } 
            }
            list.addAll(tmp);
            tmp.clear();
        }    
        list.sort(Comparator.comparing(Word::getWord));
        String[] answer = new String[list.size()];
        int idx = 0;
        for (Word word : list) {
            answer[idx++] = word.getWord();
        }
        return answer;
    }
    String convertStr(Set<Character> comb) {
        StringBuilder sb = new StringBuilder();
        for (char c : comb) {
            sb.append(c);
        }
        return sb.toString();
    }
    
    boolean isValid(Set<Character> comb) {
        for (char c : comb) {
            if (cnt[c - 'A'] < 2) {
                return false;
            }
        }
        return true;
    }
    
    void combination(char[] orderArr, int n, int r, List<Character> currentArr, int idx, int start) {
        if (idx == r) {
            Set<Character> courseComb = new TreeSet<>(currentArr);
            check.get(r).put(courseComb, check.get(r).getOrDefault(courseComb, 0) + 1);
            return;
        }
        
        for (int i = start; i < n; i++) {
            currentArr.add(orderArr[i]);
            combination(orderArr, n, r, currentArr, idx + 1, i + 1);
            currentArr.remove(currentArr.size() - 1);
        } 
    }
}