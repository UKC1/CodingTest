import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int maxX = -10001;
        int minX = 10001;
        int maxY = -10001;
        int minY = 10001;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(maxX < x) maxX = x;
            if(minX > x) minX = x;
            if(maxY < y) maxY = y;
            if(minY > y) minY = y;
        }
        System.out.println((maxX - minX) * (maxY - minY));
    }
}
