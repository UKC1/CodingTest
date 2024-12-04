import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int L;
    static int C;
    static char[] arr;
    static char[] secret;
    static StringBuilder sb;
    static Set<Character> check = new HashSet<Character>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        secret = new char[L];
        sb = new StringBuilder();
        check.add('a');
        check.add('e');
        check.add('i');
        check.add('o');
        check.add('u');
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        combination(0, 0);
        System.out.println(sb);
    }
    static void combination(int idx, int start) {
        if (idx == L) {
            if (isValid()) {
                for (int i = 0; i < L; i++) {
                    sb.append(secret[i]);
                }
                sb.append('\n');
            }
            return;
        }

        for (int i = start ; i < C; i++) {
            secret[idx] = arr[i];
            combination(idx + 1, i + 1);
        }
    }

    static boolean isValid() {
        // 최소 하나의 모음
        // 최소 두개의 자음
        int aeiouCnt = 0;
        for (int i = 0; i < L; i++) {
            if (check.contains(secret[i])) {
                aeiouCnt++;
            }
        }
        int notAeiouCnt = secret.length - aeiouCnt;
        return aeiouCnt >= 1 && notAeiouCnt >= 2;
    }
}