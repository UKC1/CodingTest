import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Word {
        String str;
        int len;
        public Word(String str) {
            this.str = str;
        }

        public int getLen() {
            return str.length();
        }

        public String getStr() {
            return str;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Word> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (String s : set) {
            list.add(new Word(s));
        }
        list.sort(Comparator.comparing(Word::getLen)
                .thenComparing(Word::getStr));
        StringBuilder sb = new StringBuilder();
        for (Word word : list) {
            sb.append(word.getStr()).append("\n");
        }
        System.out.println(sb);
    }
}