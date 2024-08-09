import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sizeA = Integer.parseInt(st.nextToken());
        int sizeB = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < sizeA; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sizeB; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int intersection = sizeA + sizeB - set.size();
        System.out.print(set.size() - intersection);
    }
}