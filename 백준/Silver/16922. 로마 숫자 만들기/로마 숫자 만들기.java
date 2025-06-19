import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        set = new HashSet<Integer>();
        /*
        I : 1
        V : 5
        X : 10
        L : 50
         */
        int[] numbers = new int[4];
        numbers[0] = 1;
        numbers[1] = 5;
        numbers[2] = 10;
        numbers[3] = 50;

        combination(N, numbers, 0, 0, 0);
        System.out.println(set.size());
    }

    static void combination(int N, int[] numbers, int index, int sum, int start) {
        if (index == N) {
            set.add(sum);
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            combination(N, numbers, index + 1, sum + numbers[i], i);
        }
    }
}
